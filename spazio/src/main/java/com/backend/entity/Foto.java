package com.backend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "FOTOS")
public class Foto {
    private int id;
    private int idLugar;
    private String rutaFoto;

    public Foto(int idLugar, String rutaFoto) {
        this.idLugar = idLugar;
        this.rutaFoto = rutaFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
}
