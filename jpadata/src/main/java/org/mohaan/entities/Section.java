package org.mohaan.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sections", schema = "tutorials")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Section extends BaseEntity {

    private String name;
    private Integer sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectures;
}
