package com.example.spazio.dto.modDTO;

import com.example.spazio.dto.entradaDTO.FotoEntradaDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class LugarModEntradaDTO {

    @NotNull(message = "Debe proveerse el id del lugar que se desea modificar")
    private Long id;

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

    public LugarModEntradaDTO() {
    }

    public LugarModEntradaDTO(Long id, String nombre, String descripcion, List<FotoEntradaDTO> fotos, List<String> caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
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

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "LugarModEntradaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fotos=" + fotos +
                ", caracteristicas=" + caracteristicas +
                '}';
    }
}
