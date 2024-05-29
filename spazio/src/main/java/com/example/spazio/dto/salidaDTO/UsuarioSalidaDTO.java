package com.example.spazio.dto.salidaDTO;



public class UsuarioSalidaDTO {

    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String tipoUsuario;

    private String firebase;

    public UsuarioSalidaDTO() {
    }

    public UsuarioSalidaDTO(Long id, String nombre, String apellido, String email, String tipoUsuario, String firebase) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.firebase = firebase;
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
}
