package org.mohaan.repositories;

import org.mohaan.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {

    List<Products> findAllByDescriptionContaining(String searchTerm);
}
