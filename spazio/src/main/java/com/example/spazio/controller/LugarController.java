package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.LugarEntradaDTO;
import com.example.spazio.dto.modDTO.LugarModEntradaDTO;
import com.example.spazio.dto.salidaDTO.LugarSalidaDTO;
import com.example.spazio.service.iLugarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lugares")
@CrossOrigin
public class LugarController {
    private iLugarService LugarService;

    public LugarController(iLugarService lugarService) {
        LugarService = lugarService;
    }
    @GetMapping("{id}")
    public ResponseEntity<LugarSalidaDTO> buscarLugarPorId(@PathVariable Long id){
        return new ResponseEntity<>(LugarService.buscarLugarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<LugarSalidaDTO>> buscarLugaresPorNombre(@RequestParam String nombre) {
        List<LugarSalidaDTO> lugares = LugarService.buscarLugaresPorNombre(nombre);
        return new ResponseEntity<>(lugares, HttpStatus.OK);
    }

    @GetMapping("/buscarPorCategoria")
    public ResponseEntity<List<LugarSalidaDTO>> buscarLugaresPorCategoria(@RequestParam Long categoriaId) {
        List<LugarSalidaDTO> lugares = LugarService.buscarLugaresPorCategoria(categoriaId);
        return new ResponseEntity<>(lugares, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<LugarSalidaDTO> agregarLugar(@RequestBody @Validated LugarEntradaDTO lugar){
        return new ResponseEntity<>(LugarService.agregarLugar(lugar), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LugarSalidaDTO>> listarLugares(){
        return new ResponseEntity<>(LugarService.listarLugares(), HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarLugar(@PathVariable Long id) {
        LugarService.eliminarLugar(id);
        return new ResponseEntity<>("Lugar eliminado correctamente", HttpStatus.OK);
    }
    @PutMapping("/actualizar")
    public LugarSalidaDTO actualizarLugar(@RequestBody LugarModEntradaDTO lugar) {
        return LugarService.actualizarLugar(lugar);
    }
}
