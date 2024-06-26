package com.example.spazio.dto.modDTO;

import com.example.spazio.dto.entradaDTO.CaracteristicaEntradaDTO;
import com.example.spazio.dto.entradaDTO.CategoriaEntradaDTO;
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

    private List<String> politicasUso;

    @NotNull
    @Size(min = 10, message = "La descripción debe tener al menos 11 letras")
    private String descripcion;

    @NotNull(message = "La lista de fotos no puede ser nula")
    @NotEmpty(message = "La lista de fotos no puede estar vacía")
    private List<FotoEntradaDTO> fotos;

    @NotNull(message = "Las características no pueden ser nulas")
    @NotEmpty(message = "Debe contener por lo menos una caracteristica")
    private List<Long> caracteristicas;

    @NotNull(message ="Las categorias no pueden ser nulas")
    @NotEmpty(message = "Debe haber por lo menos una categoria")
    private List<Long> categorias; // IDs de las categorías asociadas

    public LugarModEntradaDTO() {
    }

    public LugarModEntradaDTO(Long id, String nombre, List<String> politicasUso, String descripcion, List<FotoEntradaDTO> fotos, List<Long> caracteristicas, List<Long> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.politicasUso = politicasUso;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.categorias = categorias;
    }

    public List<String> getPoliticasUso() {
        return politicasUso;
    }

    public void setPoliticasUso(List<String> politicasUso) {
        this.politicasUso = politicasUso;
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


    public List<Long> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Long> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<Long> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Long> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "LugarModEntradaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fotos=" + fotos +
                ", caracteristicas=" + caracteristicas +
                ", categorias=" + categorias +
                '}';
    }
}
