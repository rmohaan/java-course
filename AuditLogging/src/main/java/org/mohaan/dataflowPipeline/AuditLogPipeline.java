package org.mohaan.dataflowPipeline;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;
import org.apache.beam.runners.dataflow.DataflowRunner;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.mohaan.AuditLog;

import java.util.ArrayList;
import java.util.List;

public class AuditLogPipeline {

    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(DataflowPipelineOptions.class);
        options.setRunner(DataflowRunner.class);
        options.setJobName("audit-log-ingestion-pipeline");

        Pipeline pipeline = Pipeline.create(options);

        String pubsubTopic = "projects/YOUR_PROJECT_ID/topics/audit-logs";
        String outputPath = "gs://YOUR_BUCKET_NAME/audit-logs/output";
        String bqTableSpec = "YOUR_PROJECT_ID:dataset.audit_logs";

        pipeline
                // Step 1: Read from Pub/Sub
                .apply("ReadFromPubSub", PubsubIO.readStrings().fromTopic(pubsubTopic))

                // Step 2: Parse and validate
                .apply("ParseJSON", ParDo.of(new DoFn<String, AuditLog>() {
                    @ProcessElement
                    public void processElement(@Element String json, OutputReceiver<AuditLog> out) {
                        try {
                            ObjectMapper mapper = new ObjectMapper();
                            AuditLog log = mapper.readValue(json, AuditLog.class);
                            if (log.getEventId() != null && log.getTimestamp() != null) {
                                out.output(log);
                            }
                        } catch (Exception e) {
                            // Optionally route to DLQ
                        }
                    }
                }))

                // Step 3: Write to BigQuery
                .apply("ToTableRow", ParDo.of(new DoFn<AuditLog, TableRow>() {
                    @ProcessElement
                    public void processElement(@Element AuditLog log, OutputReceiver<TableRow> out) {
                        TableRow row = new TableRow()
                                .set("eventId", log.getEventId())
                                .set("userId", log.getUserId())
                                .set("action", log.getAction())
                                .set("timestamp", log.getTimestamp())
                                .set("sourceIp", log.getSourceIp())
                                .set("metadata", log.getMetadata());
                        out.output(row);
                    }
                }))
                .apply("WriteToBigQuery", BigQueryIO.writeTableRows()
                        .to(bqTableSpec)
                        .withSchema(getBigQuerySchema())
                        .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND)
                        .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
                        .withCustomGcsTempLocation(ValueProvider.StaticValueProvider.of("gs://YOUR_BUCKET_NAME/temp")));

        // Step 4: Archive to Cloud Storage
        pipeline
                .apply("ReadAgain", PubsubIO.readStrings().fromTopic(pubsubTopic))
                .apply("WriteToGCS", TextIO.write()
                        .to(outputPath)
                        .withSuffix(".json")
                        .withWindowedWrites()
                        .withNumShards(1));

        pipeline.run();
    }

    private static TableSchema getBigQuerySchema() {
        List<TableFieldSchema> fields = new ArrayList<>();
        fields.add(new TableFieldSchema().setName("eventId").setType("STRING").setMode("REQUIRED"));
        fields.add(new TableFieldSchema().setName("userId").setType("STRING"));
        fields.add(new TableFieldSchema().setName("action").setType("STRING"));
        fields.add(new TableFieldSchema().setName("timestamp").setType("TIMESTAMP"));
        fields.add(new TableFieldSchema().setName("sourceIp").setType("STRING"));
        fields.add(new TableFieldSchema().setName("metadata").setType("RECORD").setMode("NULLABLE"));
        return new TableSchema().setFields(fields);
    }
}
