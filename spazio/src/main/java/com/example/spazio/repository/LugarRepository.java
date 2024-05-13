package com.example.spazio.repository;

import com.example.spazio.entity.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugarRepository extends JpaRepository<Lugar,Long> {
}
