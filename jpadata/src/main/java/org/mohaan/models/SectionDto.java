package org.mohaan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDto {
    private Integer id;
    private String name;
    private Integer sectionOrder;
}
