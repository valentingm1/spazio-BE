package com.example.spazio.service;

import com.example.spazio.dto.entradaDTO.CaracteristicaEntradaDTO;
import com.example.spazio.dto.salidaDTO.CaracteristicaSalidaDTO;

import java.util.List;

public interface iCaracteristicaService {
    CaracteristicaSalidaDTO agregarCaracteristica(CaracteristicaEntradaDTO caracteristicaDto);

    List<CaracteristicaSalidaDTO> listarCaracteristicas();

    CaracteristicaSalidaDTO buscarCaracteristicaPorId(Long id);

    void eliminarCaracteristica(Long id);
}
