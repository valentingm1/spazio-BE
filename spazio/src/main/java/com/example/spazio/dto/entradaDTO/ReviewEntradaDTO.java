package com.example.spazio.dto.entradaDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewEntradaDTO {

    @NotNull(message = "El ID del usuario no puede estar en blanco")
    private Long usuarioId;

    @NotNull(message = "El ID del lugar no puede estar en blanco")
    private Long lugarId;

    @NotBlank(message = "El contenido de la review no puede estar en blanco")
    private String contenido;

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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
