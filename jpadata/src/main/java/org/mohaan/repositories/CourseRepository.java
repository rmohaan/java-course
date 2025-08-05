package org.mohaan.repositories;

import jakarta.transaction.Transactional;
import org.mohaan.entities.Author;
import org.mohaan.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Modifying
    @Transactional
    @Query(
            "UPDATE Course c " +
            "SET c.name = :name, c.description = :description " +
            "WHERE c.id = :id"
    )
    int updateCourseById(String name, String description, Integer id);
}
