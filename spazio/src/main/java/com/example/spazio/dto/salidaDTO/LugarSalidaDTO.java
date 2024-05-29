package com.example.spazio.dto.salidaDTO;

import java.util.List;

public class LugarSalidaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private List<FotoSalidaDTO> fotos;
    private List<String> caracteristicas;
    private List<String> categorias;

    public LugarSalidaDTO() {
    }

    public LugarSalidaDTO(Long id, String nombre, String descripcion, List<FotoSalidaDTO> fotos, List<String> caracteristicas, List<String> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.categorias = categorias;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
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

    public List<FotoSalidaDTO> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoSalidaDTO> fotos) {
        this.fotos = fotos;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "LugarSalidaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fotos=" + fotos +
                ", caracteristicas=" + caracteristicas +
                '}';
    }
}
