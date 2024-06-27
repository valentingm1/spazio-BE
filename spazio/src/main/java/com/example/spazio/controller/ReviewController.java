package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.ReviewEntradaDTO;
import com.example.spazio.dto.modDTO.ReviewModEntradaDTO;
import com.example.spazio.dto.salidaDTO.ReviewSalidaDTO;
import com.example.spazio.entity.Review;
import com.example.spazio.service.impl.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ReviewSalidaDTO agregarReview(@RequestBody ReviewEntradaDTO reviewEntradaDTO) {
        return reviewService.agregarReview(reviewEntradaDTO);
    }

    @GetMapping("/lugar/{lugarId}")
    public List<ReviewSalidaDTO> listarReviewsPorLugar(@PathVariable Long lugarId) {
        return reviewService.listarReviewsPorLugar(lugarId);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<ReviewSalidaDTO> actualizarReview(@RequestBody ReviewModEntradaDTO reviewModificacionEntradaDTO) {
        ReviewSalidaDTO reviewActualizada = reviewService.modificarReview(reviewModificacionEntradaDTO);
        return new ResponseEntity<>(reviewActualizada, HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarReview(@PathVariable Long id) {
        reviewService.eliminarReview(id);
        return new ResponseEntity<>("Review eliminada correctamente", HttpStatus.OK);
    }
}