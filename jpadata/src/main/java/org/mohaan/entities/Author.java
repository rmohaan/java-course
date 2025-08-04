package org.mohaan.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.mohaan.entities.embedded.Address;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table (
        name = "authors",
        schema="tutorials"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(
            unique=true,
            nullable=false,
            length = 35
    )
    private String email;
    private Integer age;

    @ManyToMany(mappedBy = "authors")
    @JsonBackReference
    private List<Course> courses;

    public Author(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @Embedded
    private Address address;
}
