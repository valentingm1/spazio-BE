package com.example.spazio.dto.entradaDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CaracteristicaEntradaDTO {
    @NotNull
    @NotEmpty
    private String nombre;


    public CaracteristicaEntradaDTO(String nombre) {
        this.nombre = nombre;
    }

    public CaracteristicaEntradaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
