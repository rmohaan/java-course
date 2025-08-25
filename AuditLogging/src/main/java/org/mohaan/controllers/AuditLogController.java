package org.mohaan.controllers;

import org.mohaan.AuditLog;
import org.mohaan.logPubSub.AuditLogPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {

    private final AuditLogPublisher publisher;

    public AuditLogController(AuditLogPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    public ResponseEntity<String> logAudit(@RequestBody AuditLog request) {
        AuditLog log = AuditLog.builder()
                .eventId(UUID.randomUUID().toString())
                .userId(request.getUserId())
                .action(request.getAction())
                .timestamp(Instant.now())
                .sourceIp(request.getSourceIp())
                .metadata(request.getMetadata())
                .build();

        publisher.publish(log);
        return ResponseEntity.ok("Log published");
    }
}

