package org.mohaan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mohaan.entities.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Integer Id;
    private String name;
    private String description;
    private List<Author> authors;
}
