package com.example.spazio.repository;

import com.example.spazio.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
