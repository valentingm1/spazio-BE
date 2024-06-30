package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.RatingEntradaDTO;
import com.example.spazio.dto.modDTO.RatingModEntradaDTO;
import com.example.spazio.dto.salidaDTO.RatingSalidaDTO;
import com.example.spazio.service.impl.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@CrossOrigin
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // Crear un nuevo rating
    @PostMapping("/agregar")
    public ResponseEntity<RatingSalidaDTO> agregarRating(@RequestBody RatingEntradaDTO ratingEntradaDTO) {
        RatingSalidaDTO ratingCreado = ratingService.agregarRating(ratingEntradaDTO);
        return new ResponseEntity<>(ratingCreado, HttpStatus.CREATED);
    }

    // Obtener todos los ratings de un lugar específico
    @GetMapping("/listarPorLugar/{lugarId}")
    public ResponseEntity<List<RatingSalidaDTO>> listarRatingsPorLugar(@PathVariable Long lugarId) {
        List<RatingSalidaDTO> ratings = ratingService.listarRatingsPorLugar(lugarId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    // Actualizar un rating existente
    @PutMapping("/actualizar")
    public ResponseEntity<RatingSalidaDTO> actualizarRating(@RequestBody RatingModEntradaDTO ratingModificacionEntradaDTO) {

        RatingSalidaDTO ratingActualizado = ratingService.modificarRating(ratingModificacionEntradaDTO);;
        return new ResponseEntity<>(ratingActualizado, HttpStatus.OK);
    }

    // Eliminar un rating por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarRating(@PathVariable Long id) {
        ratingService.eliminarRating(id);
        return new ResponseEntity<>("Rating eliminado correctamente", HttpStatus.OK);
    }
}