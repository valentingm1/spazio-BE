package com.example.spazio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String rutaFoto;

    @ManyToOne
    @JoinColumn(name = "lugar_id")
    private Lugar lugar_id;

    public Foto() {
        // Constructor vacío requerido por JPA
    }

    public Foto(String rutaFoto, Lugar lugar) {
        this.rutaFoto = rutaFoto;
        this.lugar_id = lugar;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public Lugar getLugar() {
        return lugar_id;
    }

    public void setLugar(Lugar lugar) {
        this.lugar_id = lugar;
    }
}
