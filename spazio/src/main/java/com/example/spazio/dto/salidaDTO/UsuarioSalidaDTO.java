package com.example.spazio.dto.salidaDTO;


import java.util.List;

public class UsuarioSalidaDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String firebase;
    private String tipoUsuario;
    private List<LugarSalidaDTO> lugaresFavoritos;
    public UsuarioSalidaDTO() {
    }

    public UsuarioSalidaDTO(Long id, String nombre, String apellido, String email, String firebase, String tipoUsuario, List<LugarSalidaDTO> lugaresFavoritos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.firebase = firebase;
        this.tipoUsuario = tipoUsuario;
        this.lugaresFavoritos = lugaresFavoritos;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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


    public String getFirebase() {
        return firebase;
    }

    public void setFirebase(String firebase) {
        this.firebase = firebase;

    }

    public List<LugarSalidaDTO> getLugaresFavoritos() {
        return lugaresFavoritos;
    }

    public void setLugaresFavoritos(List<LugarSalidaDTO> lugaresFavoritos) {
        this.lugaresFavoritos = lugaresFavoritos;
    }
}
