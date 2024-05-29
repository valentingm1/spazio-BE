package com.example.spazio.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "lugares")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre no puede estar en blanco")
    private String nombre;
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lugar_id")
    private List<Foto> fotos;

    @ManyToMany
    @JoinTable(
            name = "lugar_caracteristica",
            joinColumns = @JoinColumn(name = "Lugar_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Caracteristica> caracteristicas;

    @ManyToMany
    @JoinTable(
            name = "lugar_categoria",
            joinColumns = @JoinColumn(name = "lugar_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    public Lugar() {
        // Constructor vacío requerido por JPA
    }

    public Lugar(String nombre, String descripcion, List<Foto> fotos, List<Caracteristica> caracteristicas, List<Categoria> categorias) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.categorias = categorias;
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

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }


    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}