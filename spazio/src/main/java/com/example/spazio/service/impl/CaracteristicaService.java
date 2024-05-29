package com.example.spazio.service.impl;


import com.example.spazio.dto.entradaDTO.CaracteristicaEntradaDTO;
import com.example.spazio.dto.salidaDTO.CaracteristicaSalidaDTO;
import com.example.spazio.entity.Caracteristica;
import com.example.spazio.repository.CaracteristicaRepository;
import com.example.spazio.service.iCaracteristicaService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaracteristicaService implements iCaracteristicaService {

    private final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);
    private final CaracteristicaRepository caracteristicaRepository;
    private final ModelMapper modelMapper;


    public CaracteristicaService(CaracteristicaRepository caracteristicaRepository, ModelMapper modelMapper) {
        this.caracteristicaRepository = caracteristicaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CaracteristicaSalidaDTO agregarCaracteristica(CaracteristicaEntradaDTO caracteristicaDto) {
        LOGGER.info("Agregando caracteristica: {}", caracteristicaDto.toString());
        Caracteristica caracteristica = modelMapper.map(caracteristicaDto, Caracteristica.class);
        Caracteristica caracteristicaPersistida = caracteristicaRepository.save(caracteristica);
        CaracteristicaSalidaDTO caracteristicaSalidaDTO = modelMapper.map(caracteristicaPersistida, CaracteristicaSalidaDTO.class);
        LOGGER.info("Caracteristica agregada exitosamente: {}", caracteristicaSalidaDTO.toString());
        return caracteristicaSalidaDTO;
    }

    @Override
    public List<CaracteristicaSalidaDTO> listarCaracteristicas() {
        LOGGER.info("Listando todas las caracteristicas");
        List<CaracteristicaSalidaDTO> caracteristicas = caracteristicaRepository.findAll().stream()
                .map(caracteristica -> modelMapper.map(caracteristica, CaracteristicaSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} caracteristicas", caracteristicas.size());
        return caracteristicas;
    }

    @Override
    public CaracteristicaSalidaDTO buscarCaracteristicaPorId(Long id) {
        LOGGER.info("Buscando caracteristica por ID: {}", id);
        Caracteristica caracteristicaBuscada = caracteristicaRepository.findById(id).orElse(null);
        CaracteristicaSalidaDTO caracteristicaSalidaDTO = caracteristicaBuscada != null ? modelMapper.map(caracteristicaBuscada, CaracteristicaSalidaDTO.class) : null;
        LOGGER.info("Caracteristica encontrada: {}", caracteristicaSalidaDTO);
        return caracteristicaSalidaDTO;
    }

    @Override
    public void eliminarCaracteristica(Long id) {
        LOGGER.info("Eliminando caracteristica con ID: {}", id);
        caracteristicaRepository.findById(id).ifPresent(caracteristica -> {
            caracteristicaRepository.delete(caracteristica);
            LOGGER.info("Caracteristica eliminada exitosamente");
        });
    }


}
