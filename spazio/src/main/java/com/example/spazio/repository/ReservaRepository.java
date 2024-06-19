package com.example.spazio.repository;

import com.example.spazio.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
    List<Reserva> findByUsuarioId(Long usuarioId);
    List<Reserva> findByLugarId(Long lugarId);
}
