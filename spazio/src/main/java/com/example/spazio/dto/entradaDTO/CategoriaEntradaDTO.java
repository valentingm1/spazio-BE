package com.example.spazio.dto.entradaDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CategoriaEntradaDTO {
    @NotNull
    @NotEmpty
    private Long id;
    @NotNull
    @NotEmpty
    private String nombre;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaEntradaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CategoriaEntradaDTO() {
    }
}
