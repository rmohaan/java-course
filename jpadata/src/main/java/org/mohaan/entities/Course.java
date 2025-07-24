package org.mohaan.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name= "courses", schema = "tutorials")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name="authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections;
}
