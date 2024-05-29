package com.example.spazio.dto.salidaDTO;

public class CategoriaSalidaDTO {
    private Long id;
    private String nombre;

    // Getters y Setters
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

    public CategoriaSalidaDTO() {
    }

    public CategoriaSalidaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
