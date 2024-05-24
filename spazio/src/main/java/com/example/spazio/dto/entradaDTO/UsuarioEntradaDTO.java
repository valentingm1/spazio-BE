package com.example.spazio.dto.entradaDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioEntradaDTO {

    @NotBlank(message = "Nombre no puede estar en blanco")
    @Size(min = 2, max = 30)
    private String nombre;

    @NotBlank(message = "Apellido no puede estar en blanco")
    @Size(min = 2, max = 50)
    private String apellido;

    @NotBlank(message = "Email no puede estar en blanco")
    @Email(message = "Email deberia ser un email válido")
    private String email;

    @NotBlank(message = "Contraseña no puede estar en blanco")
    @Size(min = 8, message = "Contraseña debe tener por lo menos 8 caracteres")
    private String password;

    public UsuarioEntradaDTO() {
    }

    public UsuarioEntradaDTO(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
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
}
