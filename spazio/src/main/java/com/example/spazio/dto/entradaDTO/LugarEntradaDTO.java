package com.example.spazio.dto.entradaDTO;

import com.example.spazio.entity.Foto;

import java.util.List;

public class LugarEntradaDTO {
    private String nombre;
    private String descripcion;
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
}
