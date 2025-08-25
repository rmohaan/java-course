package org.mohaan.controllers;

import org.mohaan.AuditLog;
import org.mohaan.services.AuditLogQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audit/query")
public class AuditLogQueryController {

    private final AuditLogQueryService service;

    public AuditLogQueryController(AuditLogQueryService service) {
        this.service = service;
    }

    @GetMapping("/user/{userId}")
    public List<AuditLog> getLogs(@PathVariable String userId) {
        return service.findLogsByUser(userId);
    }
}
