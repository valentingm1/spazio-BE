package com.example.spazio.service;


import com.example.spazio.dto.entradaDTO.UsuarioEntradaDTO;
import com.example.spazio.dto.salidaDTO.UsuarioSalidaDTO;

import java.util.List;

public interface iUsuarioService {
    UsuarioSalidaDTO agregarUsuario(UsuarioEntradaDTO Usuario);

    List<UsuarioSalidaDTO> listarUsuarios();

    UsuarioSalidaDTO buscarUsuarioPorId(Long id);

    void eliminarUsuario(Long id);

}
