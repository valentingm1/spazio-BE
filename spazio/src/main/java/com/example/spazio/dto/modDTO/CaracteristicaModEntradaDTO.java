package com.example.spazio.dto.modDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CaracteristicaModEntradaDTO {

    @NotNull
    private Long id;
    @NotEmpty
    private String nombre;


    public CaracteristicaModEntradaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CaracteristicaModEntradaDTO() {

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
