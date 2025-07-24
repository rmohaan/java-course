package org.mohaan.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "lectures",  schema = "tutorials")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resource extends BaseEntity {

    private String name;
    private String type;
    private String url;
    private Integer size;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
