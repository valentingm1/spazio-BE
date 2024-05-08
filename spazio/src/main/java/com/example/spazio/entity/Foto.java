package com.example.spazio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fotos")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_lugar")
    private Lugar Lugar;
    @Column
    private String rutaFoto;

    public Foto(com.example.spazio.entity.Lugar lugar, String rutaFoto) {
        Lugar = lugar;
        this.rutaFoto = rutaFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.example.spazio.entity.Lugar getLugar() {
        return Lugar;
    }

    public void setLugar(com.example.spazio.entity.Lugar lugar) {
        Lugar = lugar;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
}
