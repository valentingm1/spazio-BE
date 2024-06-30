package com.example.spazio.dto.entradaDTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaEntradaDTO {

    @NotNull(message = "El ID del usuario no puede ser nulo")
    @Positive(message = "El ID del usuario debe ser un número positivo")
    private Long usuarioId;

    @NotNull(message = "El ID del lugar no puede ser nulo")
    @Positive(message = "El ID del lugar debe ser un número positivo")
    private Long lugarId;

    @NotNull(message = "La fecha de la reserva no puede ser nula")
    @FutureOrPresent(message = "La fecha de la reserva debe ser hoy o en el futuro")
    private LocalDate fecha;

    @NotNull(message = "La hora de inicio no puede ser nula")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin no puede ser nula")
    private LocalTime horaFin;

    // Getters y setters

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLugarId() {
        return lugarId;
    }

    public void setLugarId(Long lugarId) {
        this.lugarId = lugarId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
