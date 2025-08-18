package org.mohaan.controllers;

import org.mohaan.services.FaultyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakController {

    private final FaultyService service;

    public CircuitBreakController(FaultyService service) {
        this.service = service;
    }

    @GetMapping("/circuit-breaker")
    public String callService() {
        return service.callExternalService();
    }
}

