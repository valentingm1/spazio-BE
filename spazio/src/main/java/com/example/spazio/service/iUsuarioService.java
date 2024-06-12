package com.example.spazio.service;


import com.example.spazio.dto.entradaDTO.UsuarioEntradaDTO;
import com.example.spazio.dto.salidaDTO.UsuarioSalidaDTO;

import java.util.List;

public interface iUsuarioService {
    UsuarioSalidaDTO agregarUsuario(UsuarioEntradaDTO Usuario);

    List<UsuarioSalidaDTO> listarUsuarios();

    UsuarioSalidaDTO buscarUsuarioPorId(Long id);

    UsuarioSalidaDTO buscarUsuarioPorEmail(String email);

    void eliminarUsuario(Long id);

    UsuarioSalidaDTO agregarLugarFavorito(Long usuarioId, Long lugarId);
}
