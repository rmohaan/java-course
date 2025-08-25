package org.mohaan;

import java.time.Instant;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {
    private String eventId;         // UUID
    private String userId;
    private String action;
    private Instant timestamp;
    private String sourceIp;
    private Map<String, Object> metadata;
}
