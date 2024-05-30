package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.CategoriaEntradaDTO;
import com.example.spazio.dto.modDTO.CategoriaModEntradaDTO;
import com.example.spazio.dto.salidaDTO.CategoriaSalidaDTO;
import com.example.spazio.service.iCategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class CategoriaController {

    private final iCategoriaService categoriaService;

    public CategoriaController(iCategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaSalidaDTO> buscarCategoriaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(categoriaService.buscarCategoriaPorId(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<CategoriaSalidaDTO> agregarCategoria(@RequestBody @Validated CategoriaEntradaDTO categoriaDto) {
        return new ResponseEntity<>(categoriaService.agregarCategoria(categoriaDto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaSalidaDTO>> listarCategorias() {
        return new ResponseEntity<>(categoriaService.listarCategorias(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return new ResponseEntity<>("Categoría eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CategoriaSalidaDTO> actualizarCategoria(@RequestBody @Validated CategoriaModEntradaDTO categoriaModDto) {
        return new ResponseEntity<>(categoriaService.actualizarCategoria(categoriaModDto), HttpStatus.OK);
    }

}
