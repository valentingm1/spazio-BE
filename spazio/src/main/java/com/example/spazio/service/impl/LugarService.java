package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.LugarEntradaDTO;
import com.example.spazio.dto.modDTO.LugarModEntradaDTO;
import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;
import com.example.spazio.entity.Categoria;
import com.example.spazio.entity.Lugar;
import com.example.spazio.repository.CategoriaRepository;
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
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    public LugarService(LugarRepository lugarRepository, CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.lugarRepository = lugarRepository;
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    public LugarSalidaDTO agregarLugar(LugarEntradaDTO lugarDto) {
        LOGGER.info("Agregando lugar: {}", lugarDto.toString());

        Lugar lugar = modelMapper.map(lugarDto, Lugar.class);

        // Convertir IDs de categorías a entidades de categorías
        List<Categoria> categorias = lugarDto.getCategorias().stream()
                .map(categoriaRepository::findById)
                .map(optionalCategoria -> optionalCategoria.orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada")))
                .collect(Collectors.toList());
        lugar.setCategorias(categorias);

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

    @Override
    public LugarSalidaDTO actualizarLugar(LugarModEntradaDTO lugar) {
        Lugar LugarRecibido = modelMapper.map(lugar, Lugar.class);
        Lugar LugarAActualizar = lugarRepository.findById(LugarRecibido.getId()).orElse(null);

        LugarSalidaDTO LugarSalidaDto = null;

        if (LugarAActualizar != null) {
            LugarAActualizar = LugarRecibido;
            lugarRepository.save(LugarAActualizar);

            LugarSalidaDto = modelMapper.map(LugarAActualizar, LugarSalidaDTO.class);
            LOGGER.warn("Paciente actualizado: {}", LugarSalidaDto.toString());

        } else {
            LOGGER.error("No fue posible actualizar el paciente porque no se encuentra en nuestra base de datos");
            //lanzar excepcion correspondiente
        }


        return LugarSalidaDto;
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
