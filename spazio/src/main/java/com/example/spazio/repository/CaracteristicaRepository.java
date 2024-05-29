package com.example.spazio.repository;

import com.example.spazio.entity.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CaracteristicaRepository extends JpaRepository<Caracteristica,Long> {
}
