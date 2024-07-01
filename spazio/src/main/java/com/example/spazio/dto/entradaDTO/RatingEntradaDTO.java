package com.example.spazio.dto.entradaDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RatingEntradaDTO {

    @NotNull(message = "El ID del usuario no puede estar en blanco")
    private Long usuarioId;

    @NotNull(message = "El ID del lugar no puede estar en blanco")
    private Long lugarId;

    @Min(value = 1, message = "El rating debe ser al menos 1")
    @Max(value = 5, message = "El rating debe ser como máximo 5")
    private float rating;

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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
