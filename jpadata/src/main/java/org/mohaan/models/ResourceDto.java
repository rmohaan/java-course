package org.mohaan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto {
    private Integer id;
    private String name;
    private String type; // e.g., "video", "document", "link"
    private String url; // URL or path to the resource
    private Integer size;
}

