package com.example.spazio.dto.modDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReviewModEntradaDTO {

    @NotNull(message = "El ID de la review no puede ser nulo")
    private Long id;

    @NotBlank(message = "El contenido de la review no puede estar en blanco")
    @Size(min = 10, message = "El contenido de la review debe tener al menos 10 caracteres")
    private String contenido;

    public ReviewModEntradaDTO(Long id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}