package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.LugarEntradaDTO;
import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;
import com.example.spazio.entity.Lugar;
import com.example.spazio.repository.LugarRepository;
import com.example.spazio.service.iLugarService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LugarService implements iLugarService {

    private final Logger LOGGER = LoggerFactory.getLogger(LugarService.class);
    private final LugarRepository lugarRepository;
    private final ModelMapper modelMapper;

    public LugarService(LugarRepository lugarRepository, ModelMapper modelMapper) {
        this.lugarRepository = lugarRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public LugarSalidaDTO agregarLugar(LugarEntradaDTO lugarDto) {
        LOGGER.info("Agregando lugar: {}", lugarDto.toString());
        Lugar lugar = modelMapper.map(lugarDto, Lugar.class);
        Lugar lugarPersistido = lugarRepository.save(lugar);
        LugarSalidaDTO lugarSalidaDTO = modelMapper.map(lugarPersistido, LugarSalidaDTO.class);
        LOGGER.info("Lugar agregado exitosamente: {}", lugarSalidaDTO.toString());
        return lugarSalidaDTO;
    }

    @Override
    public List<LugarSalidaDTO> listarLugares() {
        LOGGER.info("Listando todos los lugares");
        List<LugarSalidaDTO> lugares = lugarRepository.findAll().stream()
                .map(lugar -> modelMapper.map(lugar, LugarSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} lugares", lugares.size());
        return lugares;
    }

    @Override
    public LugarSalidaDTO buscarLugarPorId(Long id) {
        LOGGER.info("Buscando lugar por ID: {}", id);
        Lugar lugarBuscado = lugarRepository.findById(id).orElse(null);
        LugarSalidaDTO lugarSalidaDTO = lugarBuscado != null ? modelMapper.map(lugarBuscado, LugarSalidaDTO.class) : null;
        LOGGER.info("Lugar encontrado: {}", lugarSalidaDTO);
        return lugarSalidaDTO;
    }

    @Override
    public void eliminarLugar(Long id) {
        LOGGER.info("Eliminando lugar con ID: {}", id);
        lugarRepository.findById(id).ifPresent(lugar -> {
            lugarRepository.delete(lugar);
            LOGGER.info("Lugar eliminado exitosamente");
        });
    }

    private void configureMapping() {
        // Mapeo de LugarEntradaDTO a Lugar
        modelMapper.typeMap(LugarEntradaDTO.class, Lugar.class)
                .addMapping(LugarEntradaDTO::getFotos, Lugar::setFotos);

        // Mapeo de Lugar a LugarSalidaDTO
        modelMapper.typeMap(Lugar.class, LugarSalidaDTO.class)
                .addMapping(src -> src.getId(), LugarSalidaDTO::setId) // Mapeo del ID del lugar
                .addMapping(Lugar::getFotos, LugarSalidaDTO::setFotos);



    }


}