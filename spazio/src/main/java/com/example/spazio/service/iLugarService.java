package com.example.spazio.service;

import com.example.spazio.dto.entradaDTO.LugarEntradaDTO;
import com.example.spazio.dto.modDTO.LugarModEntradaDTO;
import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;

import java.util.List;

public interface iLugarService {
    LugarSalidaDTO agregarLugar(LugarEntradaDTO Lugar);

    List<LugarSalidaDTO> listarLugares();

    LugarSalidaDTO buscarLugarPorId(Long id);

    void eliminarLugar(Long id);

    LugarSalidaDTO actualizarLugar(LugarModEntradaDTO lugar);
}
