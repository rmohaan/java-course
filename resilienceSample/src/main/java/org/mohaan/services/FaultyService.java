package org.mohaan.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FaultyService {

    private final Random random = new Random();

    @CircuitBreaker(name = "SomeExternalService", fallbackMethod = "fallbackInvoke")
    public String callExternalService() {
        if (random.nextInt(10) < 8) { // 80% chance to fail
            throw new RuntimeException("External service failed");
        }
        return "Success from external service";
    }

    public String fallbackInvoke(Throwable t) {
        return "Fallback: Service unavailable (" + t.getClass().getSimpleName() + ")";
    }
}
