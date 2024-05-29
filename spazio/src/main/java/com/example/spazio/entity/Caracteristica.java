package com.example.spazio.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;

import java.util.List;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 50)
    private String nombre;



    @ManyToMany(mappedBy = "caracteristicas")
    private List<Lugar> lugares;

    public Caracteristica() {
    }

    public Caracteristica(String nombre, List<Lugar> lugares) {
        this.nombre = nombre;
        this.lugares = lugares;
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

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }
}
