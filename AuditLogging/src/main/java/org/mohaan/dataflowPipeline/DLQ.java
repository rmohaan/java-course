package org.mohaan.dataflowPipeline;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.beam.runners.dataflow.DataflowRunner;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionTuple;
import org.apache.beam.sdk.values.TupleTag;
import org.apache.beam.sdk.values.TupleTagList;
import org.mohaan.AuditLog;

public class DLQ {

    PipelineOptions options = PipelineOptionsFactory.fromArgs().withValidation().as(DataflowPipelineOptions.class);

    Pipeline pipeline = Pipeline.create(options);
    String pubsubTopic = "projects/YOUR_PROJECT_ID/topics/audit-logs";

    PCollection<String> input = pipeline.apply("ReadFromPubSub", PubsubIO.readStrings().fromTopic(pubsubTopic));

    TupleTag<AuditLog> validTag = new TupleTag<>() {};
    TupleTag<String> deadLetterTag = new TupleTag<>() {};

    PCollectionTuple parsed = input.apply("Parse", ParDo.of(new DoFn<String, AuditLog>() {
        @ProcessElement
        public void processElement(@Element String json, MultiOutputReceiver out) {
            try {
                AuditLog log = new ObjectMapper().readValue(json, AuditLog.class);
                out.get(validTag).output(log);
            } catch (Exception e) {
                out.get(deadLetterTag).output(json);
            }
        }
    }).withOutputTags(validTag, TupleTagList.of(deadLetterTag)));

//    parsed.get(deadLetterTag)
//            .apply("WriteDLQ",TextIO.write().to("gs://your-bucket-name/dead-letter").withSuffix(".txt"));

}
