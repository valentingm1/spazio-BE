package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.CategoriaEntradaDTO;
import com.example.spazio.dto.modDTO.CategoriaModEntradaDTO;
import com.example.spazio.dto.salidaDTO.CategoriaSalidaDTO;
import com.example.spazio.entity.Categoria;
import com.example.spazio.repository.CategoriaRepository;
import com.example.spazio.service.iCategoriaService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService implements iCategoriaService {

    private final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);
    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoriaSalidaDTO agregarCategoria(CategoriaEntradaDTO categoriaDto) {
        LOGGER.info("Agregando categoria: {}", categoriaDto.toString());
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria categoriaPersistida = categoriaRepository.save(categoria);
        CategoriaSalidaDTO categoriaSalidaDTO = modelMapper.map(categoriaPersistida, CategoriaSalidaDTO.class);
        LOGGER.info("Categoria agregada exitosamente: {}", categoriaSalidaDTO.toString());
        return categoriaSalidaDTO;
    }

    @Override
    public List<CategoriaSalidaDTO> listarCategorias() {
        LOGGER.info("Listando todas las categorias");
        List<CategoriaSalidaDTO> categorias = categoriaRepository.findAll().stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} categorias", categorias.size());
        return categorias;
    }

    @Override
    public CategoriaSalidaDTO buscarCategoriaPorId(Long id) {
        LOGGER.info("Buscando categoria por ID: {}", id);
        Categoria categoriaBuscada = categoriaRepository.findById(id).orElse(null);
        CategoriaSalidaDTO categoriaSalidaDTO = categoriaBuscada != null ? modelMapper.map(categoriaBuscada, CategoriaSalidaDTO.class) : null;
        LOGGER.info("Categoria encontrada: {}", categoriaSalidaDTO);
        return categoriaSalidaDTO;
    }

    @Override
    public void eliminarCategoria(Long id) {
        LOGGER.info("Eliminando categoria con ID: {}", id);
        categoriaRepository.findById(id).ifPresent(categoria -> {
            categoriaRepository.delete(categoria);
            LOGGER.info("Categoria eliminada exitosamente");
        });
    }
    @Override
    public CategoriaSalidaDTO actualizarCategoria(CategoriaModEntradaDTO categoriaModDto) {
        Long id = categoriaModDto.getId();
        LOGGER.info("Actualizando categoria con ID: {}", id);

        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada con ID: " + id));

        // Actualizar los campos del categoriaExistente con los valores del DTO
        modelMapper.map(categoriaModDto, categoriaExistente);

        Categoria categoriaActualizada = categoriaRepository.save(categoriaExistente);
        CategoriaSalidaDTO categoriaSalidaDTO = modelMapper.map(categoriaActualizada, CategoriaSalidaDTO.class);

        LOGGER.info("Categoria actualizada exitosamente: {}", categoriaSalidaDTO.toString());
        return categoriaSalidaDTO;
    }

}
