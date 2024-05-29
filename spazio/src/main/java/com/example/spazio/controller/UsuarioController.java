package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.UsuarioEntradaDTO;

import com.example.spazio.dto.salidaDTO.UsuarioSalidaDTO;
import com.example.spazio.service.iUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    private iUsuarioService UsuarioService;


    public UsuarioController(iUsuarioService usuarioService) {
        UsuarioService = usuarioService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<UsuarioSalidaDTO> agregarUsuario(@Validated @RequestBody UsuarioEntradaDTO usuarioEntradaDTO) {
        return new ResponseEntity<>(UsuarioService.agregarUsuario(usuarioEntradaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioSalidaDTO>> listarUsuarios(){
        return new ResponseEntity<>(UsuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioSalidaDTO> buscarUsuarioPorId(@PathVariable Long id){
        return new ResponseEntity<>(UsuarioService.buscarUsuarioPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        UsuarioService.eliminarUsuario(id);
        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
    }
}