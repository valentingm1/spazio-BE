package com.example.spazio.dto.entradaDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CategoriaEntradaDTO {
    @NotNull
    @NotEmpty
    private String nombre;

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaEntradaDTO(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaEntradaDTO() {
    }
}
