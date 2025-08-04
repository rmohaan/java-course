package org.mohaan.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mohaan.entities.Course;
import org.mohaan.entities.embedded.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private List<Course> courses;
    private Address address;
}
