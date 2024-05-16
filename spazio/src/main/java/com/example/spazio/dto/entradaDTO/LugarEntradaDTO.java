package com.example.spazio.dto.entradaDTO;

import com.example.spazio.entity.Foto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class LugarEntradaDTO {
    @NotNull
    @Size(min = 5, message = "El nombre debe tener al menos 5 letras")
    @NotEmpty
    private String nombre;

    @NotNull
    @Size(min = 10, message = "La descripción debe tener al menos 11 letras")
    private String descripcion;

    @NotNull(message = "La lista de fotos no puede ser nula")
    @NotEmpty(message = "La lista de fotos no puede estar vacía")
    private List<FotoEntradaDTO> fotos;

    public LugarEntradaDTO() {
    }

    public LugarEntradaDTO(String nombre, String descripcion, List<FotoEntradaDTO> fotos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<FotoEntradaDTO> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoEntradaDTO> fotos) {
        this.fotos = fotos;
    }

    @Override
    public String toString() {
        return "LugarEntradaDTO{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
