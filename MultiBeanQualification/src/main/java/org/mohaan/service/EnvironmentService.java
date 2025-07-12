package org.mohaan.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentService {
    private final Environment environment;

    @Getter
    @Value("${my.custom.property.name}")
    private String nameProperty;

    @Autowired
    public EnvironmentService(Environment environment){
        this.environment = environment;
    }

    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    public String getCustomProperty() {
        return environment.getProperty("my.custom.property");
    }

}
