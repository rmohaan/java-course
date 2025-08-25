package org.mohaan.logPubSub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import org.mohaan.AuditLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuditLogPublisher {

    private final PubSubTemplate pubSubTemplate;
    @Value("${app.pubsub.topic}")
    private String topicName;

    public AuditLogPublisher(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }

    public void publish(AuditLog log) {
        try {
            String payload = new ObjectMapper().writeValueAsString(log);
            pubSubTemplate.publish(topicName, payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing audit log", e);
        }
    }
}

