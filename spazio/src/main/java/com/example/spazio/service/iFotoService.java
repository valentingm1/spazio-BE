package com.example.spazio.service;


import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;

import com.example.spazio.dto.entradaDTO.FotoEntradaDTO;
import com.example.spazio.dto.salidaDTO.FotoSalidaDTO;

import java.util.List;

public interface iFotoService {
    FotoSalidaDTO agregarFoto(FotoEntradaDTO foto);
}
