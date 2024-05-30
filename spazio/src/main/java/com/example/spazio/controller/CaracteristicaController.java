package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.CaracteristicaEntradaDTO;
import com.example.spazio.dto.salidaDTO.CaracteristicaSalidaDTO;
import com.example.spazio.service.iCaracteristicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caracteristicas")
@CrossOrigin
public class CaracteristicaController {
    private final iCaracteristicaService caracteristicaService;

    public CaracteristicaController(iCaracteristicaService caracteristicaService) {
        this.caracteristicaService = caracteristicaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaracteristicaSalidaDTO> buscarCaracteristicaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(caracteristicaService.buscarCaracteristicaPorId(id), HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<CaracteristicaSalidaDTO> agregarCaracteristica(@RequestBody @Validated CaracteristicaEntradaDTO caracteristicaDto) {
        return new ResponseEntity<>(caracteristicaService.agregarCaracteristica(caracteristicaDto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CaracteristicaSalidaDTO>> listarCaracteristicas() {
        return new ResponseEntity<>(caracteristicaService.listarCaracteristicas(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCaracteristica(@PathVariable Long id) {
        caracteristicaService.eliminarCaracteristica(id);
        return new ResponseEntity<>("Característica eliminada correctamente", HttpStatus.OK);
    }
}
