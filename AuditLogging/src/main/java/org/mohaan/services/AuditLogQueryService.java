package org.mohaan.services;

import com.google.cloud.bigquery.*;
import org.mohaan.AuditLog;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditLogQueryService {

    private final BigQuery bigQuery;

    public AuditLogQueryService() {
        this.bigQuery = BigQueryOptions.getDefaultInstance().getService();
    }

    public List<AuditLog> findLogsByUser(String userId) {
        String query = String.format("""
                SELECT eventId, userId, action, timestamp, sourceIp
                FROM `your-project.dataset.audit_logs`
                WHERE userId = '%s'
                ORDER BY timestamp DESC
                LIMIT 100
                """, userId);

        QueryJobConfiguration config = QueryJobConfiguration.newBuilder(query).build();

        try {
            TableResult result = bigQuery.query(config);

            List<AuditLog> logs = new ArrayList<>();
            for (FieldValueList row : result.iterateAll()) {
                logs.add(AuditLog.builder()
                        .eventId(row.get("eventId").getStringValue())
                        .userId(row.get("userId").getStringValue())
                        .action(row.get("action").getStringValue())
                        .timestamp(Instant.parse(row.get("timestamp").getStringValue()))
                        .sourceIp(row.get("sourceIp").getStringValue())
                        .build());
            }
            return logs;
        } catch (InterruptedException e) {
            throw new RuntimeException("Query failed", e);
        }
    }
}

