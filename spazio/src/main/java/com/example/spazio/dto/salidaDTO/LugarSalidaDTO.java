package com.example.spazio.dto.salidaDTO;

import java.util.List;

public class LugarSalidaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private List<FotoSalidaDTO> fotos;

    public LugarSalidaDTO() {
    }

    public LugarSalidaDTO(Long id, String nombre, String descripcion, List<FotoSalidaDTO> fotos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
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

    public List<FotoSalidaDTO> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoSalidaDTO> fotos) {
        this.fotos = fotos;
    }
}
