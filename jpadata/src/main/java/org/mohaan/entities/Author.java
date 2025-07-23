package org.mohaan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table (
        name = "authors",
        schema="tutorials"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(
            unique=true,
            nullable=false,
            length = 35
    )
    private String email;
    private Integer age;

    @Column(
            updatable=false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @Column (
            insertable = false
    )
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

    public Author(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }



}
