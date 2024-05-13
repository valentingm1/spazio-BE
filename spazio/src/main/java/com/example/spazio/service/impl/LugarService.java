package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.LugarEntradaDTO;
import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;
import com.example.spazio.entity.Lugar;
import com.example.spazio.repository.LugarRepository;
import com.example.spazio.service.iLugarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LugarService implements iLugarService {

    private final LugarRepository lugarRepository;
    private final ModelMapper modelMapper;

    public LugarService(LugarRepository lugarRepository, ModelMapper modelMapper) {
        this.lugarRepository = lugarRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public LugarSalidaDTO agregarLugar(LugarEntradaDTO lugarDto) {
        Lugar lugar = modelMapper.map(lugarDto, Lugar.class);
        Lugar lugarPersistido = lugarRepository.save(lugar);
        LugarSalidaDTO lugarSalidaDTO = modelMapper.map(lugarPersistido, LugarSalidaDTO.class);
        return lugarSalidaDTO;
    }

    @Override
    public List<LugarSalidaDTO> listarLugares() {
        return lugarRepository.findAll().stream()
                .map(lugar -> modelMapper.map(lugar, LugarSalidaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public LugarSalidaDTO buscarLugarPorId(Long id) {
        Lugar lugarBuscado = lugarRepository.findById(id).orElse(null);
        return lugarBuscado != null ? modelMapper.map(lugarBuscado, LugarSalidaDTO.class) : null;
    }

    @Override
    public void eliminarLugar(Long id) {
        lugarRepository.findById(id).ifPresent(lugarRepository::delete);
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
