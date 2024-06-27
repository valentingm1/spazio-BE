package com.example.spazio.repository;

import com.example.spazio.entity.Lugar;
import com.example.spazio.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
    List<Reserva> findByUsuarioId(Long usuarioId);
    List<Reserva> findByLugarId(Long lugarId);

    // Obtener reservas por usuario y lugar
    @Query("SELECT r FROM Reserva r WHERE r.usuario.id = :usuarioId AND r.lugar.id = :lugarId")
    List<Reserva> findReservasByUsuarioIdAndLugarId(@Param("usuarioId") Long usuarioId, @Param("lugarId") Long lugarId);

}
