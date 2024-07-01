package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.UsuarioEntradaDTO;

import com.example.spazio.dto.salidaDTO.UsuarioSalidaDTO;
import com.example.spazio.service.iUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

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
    @PostMapping("/{usuarioId}/favoritos/{lugarId}")
    public ResponseEntity<UsuarioSalidaDTO> agregarLugarFavorito(
            @PathVariable Long usuarioId,
            @PathVariable Long lugarId) {
        UsuarioSalidaDTO usuarioSalidaDTO = UsuarioService.agregarLugarFavorito(usuarioId, lugarId);
        return ResponseEntity.ok(usuarioSalidaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSalidaDTO> buscarUsuarioPorId(@PathVariable Long id){
        return new ResponseEntity<>(UsuarioService.buscarUsuarioPorId(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<UsuarioSalidaDTO> buscarUsuarioPorEmail(@PathVariable String email){
        return new ResponseEntity<>(UsuarioService.buscarUsuarioPorEmail(email), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioSalidaDTO>> listarUsuarios(){
        return new ResponseEntity<>(UsuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        UsuarioService.eliminarUsuario(id);
        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
    }
}