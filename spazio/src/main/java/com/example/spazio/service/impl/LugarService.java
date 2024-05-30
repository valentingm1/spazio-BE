package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.LugarEntradaDTO;
import com.example.spazio.dto.modDTO.LugarModEntradaDTO;
import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;
import com.example.spazio.entity.Caracteristica;
import com.example.spazio.entity.Categoria;
import com.example.spazio.entity.Foto;
import com.example.spazio.entity.Lugar;
import com.example.spazio.repository.CaracteristicaRepository;
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
    private final CaracteristicaRepository caracteristicaRepository;
    private final ModelMapper modelMapper;

    public LugarService(LugarRepository lugarRepository, CategoriaRepository categoriaRepository, CaracteristicaRepository caracteristicaRepository, ModelMapper modelMapper) {
        this.lugarRepository = lugarRepository;
        this.categoriaRepository = categoriaRepository;
        this.caracteristicaRepository = caracteristicaRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    public LugarSalidaDTO agregarLugar(LugarEntradaDTO lugarDto) {
        LOGGER.info("Agregando lugar: {}", lugarDto.toString());

        Lugar lugar = modelMapper.map(lugarDto, Lugar.class);

        // Convertir IDs de categorías a entidades de categorías
        List<Categoria> categorias = lugarDto.getCategorias().stream()
                .map(categoriaId -> categoriaRepository.findById(categoriaId)
                        .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada")))
                .collect(Collectors.toList());
        lugar.setCategorias(categorias);

        List<Caracteristica> caracteristicas = lugarDto.getCaracteristicas().stream()
                .map(caracteristicaId -> caracteristicaRepository.findById(caracteristicaId)
                        .orElseThrow(() -> new IllegalArgumentException("Característica no encontrada con ID: " + caracteristicaId)))
                .collect(Collectors.toList());
        lugar.setCaracteristicas(caracteristicas);

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
    public LugarSalidaDTO actualizarLugar(LugarModEntradaDTO lugarModDto) {
        Long id = lugarModDto.getId();
        LOGGER.info("Actualizando lugar con ID: {}", id);

        Lugar lugarExistente = lugarRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lugar no encontrado con ID: " + id));

        // Actualizar los campos del lugar existente con los valores del DTO
        if (lugarModDto.getNombre() != null) {
            lugarExistente.setNombre(lugarModDto.getNombre());
        }
        if (lugarModDto.getDescripcion() != null) {
            lugarExistente.setDescripcion(lugarModDto.getDescripcion());
        }

        // Convertir IDs de categorías a entidades de categorías
        if (lugarModDto.getCategorias() != null) {
            List<Categoria> categorias = lugarModDto.getCategorias().stream()
                    .map(categoriaId -> categoriaRepository.findById(categoriaId)
                            .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada con ID: " + categoriaId)))
                    .collect(Collectors.toList());
            lugarExistente.setCategorias(categorias);
        }

        // Convertir IDs de características a entidades de características
        if (lugarModDto.getCaracteristicas() != null) {
            List<Caracteristica> caracteristicas = lugarModDto.getCaracteristicas().stream()
                    .map(caracteristicaId -> caracteristicaRepository.findById(caracteristicaId)
                            .orElseThrow(() -> new IllegalArgumentException("Característica no encontrada con ID: " + caracteristicaId)))
                    .collect(Collectors.toList());
            lugarExistente.setCaracteristicas(caracteristicas);
        }

        // Actualizar las fotos existentes


        Lugar lugarActualizado = lugarRepository.save(lugarExistente);
        LugarSalidaDTO lugarSalidaDTO = modelMapper.map(lugarActualizado, LugarSalidaDTO.class);
        LOGGER.info("Lugar actualizado exitosamente: {}", lugarSalidaDTO.toString());
        return lugarSalidaDTO;
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
