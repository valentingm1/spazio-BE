package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.FotoEntradaDTO;
import com.example.spazio.dto.salidaDTO.FotoSalidaDTO;
import com.example.spazio.service.iFotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fotos")
@CrossOrigin
public class FotoController {
    private final iFotoService fotoService;

    public FotoController(iFotoService fotoService) {
        this.fotoService = fotoService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<FotoSalidaDTO> agregarFoto(@RequestBody FotoEntradaDTO foto) {
        FotoSalidaDTO fotoCreada = fotoService.agregarFoto(foto);
        return new ResponseEntity<>(fotoCreada, HttpStatus.CREATED);
    }
}
