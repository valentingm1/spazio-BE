package com.example.spazio.dto.salidaDTO;

public class LugarSalidaDTO {
    private String nombre;
    private String descripcion;
    private Long id;

    public LugarSalidaDTO() {
    }

    public LugarSalidaDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
}
