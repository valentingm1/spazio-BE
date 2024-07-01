package com.example.spazio.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "usuario_lugar_favorito",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "lugar_id")
    )
    private List<Lugar> lugaresFavoritos = new ArrayList<>(); // Inicialización de la lista



    @NotBlank(message = "idFirebase no puede estar en blanco")
    @Size(min = 8, message = "idFirebase debe tener por lo menos 8 caracteres")
    private String firebase;


    @Nullable // Solución parche a tipos de usuario
    private String tipoUsuario;

    public Usuario(Long id, String nombre, String apellido, String email, String password, String firebase, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.firebase = firebase;
        this.tipoUsuario = tipoUsuario;
        this.lugaresFavoritos = new ArrayList<>(); // Inicializa la lista en el constructor
    }
    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String email, String password, List<Lugar> lugaresFavoritos, String firebase, @Nullable String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.lugaresFavoritos = lugaresFavoritos;
        this.firebase = firebase;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nombre, String apellido, String email, String password, String tipoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFirebase() {
        return firebase;
    }

    public void setFirebase(String firebase) {
        this.firebase = firebase;
    }

    public List<Lugar> getLugaresFavoritos() {
        return lugaresFavoritos;
    }

    public void setLugaresFavoritos(List<Lugar> lugaresFavoritos) {
        this.lugaresFavoritos = lugaresFavoritos;
    }
}
