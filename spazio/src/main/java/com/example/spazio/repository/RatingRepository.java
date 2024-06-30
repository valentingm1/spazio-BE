package com.example.spazio.repository;

import com.example.spazio.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
        List<Rating> findByLugarId(Long lugarId);
    Rating findByUsuarioIdAndLugarId(Long usuarioId, Long lugarId);
}
