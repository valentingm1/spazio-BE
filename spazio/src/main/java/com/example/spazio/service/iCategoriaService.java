package com.example.spazio.service;

import com.example.spazio.dto.entradaDTO.CategoriaEntradaDTO;
import com.example.spazio.dto.salidaDTO.CategoriaSalidaDTO;

import java.util.List;

public interface iCategoriaService {
    CategoriaSalidaDTO agregarCategoria(CategoriaEntradaDTO categoriaDto);

    List<CategoriaSalidaDTO> listarCategorias();

    CategoriaSalidaDTO buscarCategoriaPorId(Long id);

    void eliminarCategoria(Long id);

}
