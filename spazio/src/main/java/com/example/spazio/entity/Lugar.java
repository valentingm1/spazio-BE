package com.example.spazio.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
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

    private List<String> politicasDeUso;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "lugar_id")
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

    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings = new ArrayList<>();

    public Lugar() {
        // Constructor vacío requerido por JPA
    }

    public Lugar(Long id, String nombre, String descripcion, List<String> politicasDeUso, List<Foto> fotos, List<Caracteristica> caracteristicas, List<Categoria> categorias, List<Reserva> reservas, List<Review> reviews, List<Rating> ratings) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.politicasDeUso = politicasDeUso;
        this.fotos = fotos;
        this.caracteristicas = caracteristicas;
        this.categorias = categorias;
        this.reservas = reservas;
        this.reviews = reviews;
        this.ratings = ratings;
    }

    public List<String> getPoliticasDeUso() {
        return politicasDeUso;
    }

    public void setPoliticasDeUso(List<String> politicasDeUso) {
        this.politicasDeUso = politicasDeUso;
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


    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}