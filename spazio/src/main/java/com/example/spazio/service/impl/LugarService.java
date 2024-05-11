package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.LugarEntradaDTO;
import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;
import com.example.spazio.entity.Lugar;
import com.example.spazio.repository.LugarRepository;
import com.example.spazio.service.iLugarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarService implements iLugarService {
    private final LugarRepository LugarRepository;
    private final ModelMapper ModelMapper;


    public LugarService(com.example.spazio.repository.LugarRepository lugarRepository, org.modelmapper.ModelMapper modelMapper) {
        LugarRepository = lugarRepository;
        ModelMapper = modelMapper;
    }

    public LugarSalidaDTO agregarLugar(LugarEntradaDTO Lugar){
        Lugar lugarEntidad = ModelMapper.map(Lugar, Lugar.class);

        Lugar lugarAPersistir = LugarRepository.save(lugarEntidad);
        LugarSalidaDTO lugarSalidaDTO = ModelMapper.map(lugarAPersistir, LugarSalidaDTO.class);
        return lugarSalidaDTO;
    }

    public List<LugarSalidaDTO> listarLugares(){
        List<LugarSalidaDTO> lugarSalidaDTOList = LugarRepository.findAll()
                .stream()
                .map(lugar -> ModelMapper.map(lugar, LugarSalidaDTO.class))
                .toList();
        return lugarSalidaDTOList;
    }

    public LugarSalidaDTO buscarLugarPorId(Long id){
        Lugar lugarBuscado = LugarRepository.findById(id).orElse(null);
        LugarSalidaDTO lugarEncontrado = null;

        if(lugarBuscado != null){
            lugarEncontrado = ModelMapper.map(lugarBuscado, LugarSalidaDTO.class);
        }
        return lugarEncontrado;
    }

    public void eliminarLugar(Long id){
        if(LugarRepository.findById(id).orElse(null) != null){
            LugarRepository.deleteById(id);
        }
    }
}
