package com.example.spazio.dto.entradaDTO;

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

    @NotNull(message = "Las características no pueden ser nulas")
    @NotEmpty(message = "Debe contener por lo menos una caracteristica")
    private List<String> caracteristicas;

    @NotNull(message ="Las categorias no pueden ser nulas")
    @NotEmpty(message = "Debe haber por lo menos una categoria")
    private List<Long> categorias; // IDs de las categorías asociadas

    public LugarEntradaDTO() {
    }

    public LugarEntradaDTO(String nombre, String descripcion, List<FotoEntradaDTO> fotos, List<String> caracteristicas, List<Long> categorias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.categorias = categorias;
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


    public List<Long> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Long> categorias) {
        this.categorias = categorias;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "LugarEntradaDTO{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
