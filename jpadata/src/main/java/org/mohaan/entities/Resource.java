package org.mohaan.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "lectures",  schema = "tutorials")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String url;
    private Integer size;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
