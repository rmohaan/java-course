package org.mohaan.repositories;

import org.mohaan.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByIdIn(List<Integer> ids);
    List<Author> findByLastNameContainingIgnoreCase(String lastName);
}
