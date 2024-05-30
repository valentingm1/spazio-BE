package com.example.spazio.dto.modDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaModEntradaDTO {

    @NotNull(message = "El ID no puede estar en blanco")
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;


    public CategoriaModEntradaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CategoriaModEntradaDTO() {
    }

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
}
