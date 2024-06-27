package com.example.spazio.service;

import com.example.spazio.dto.entradaDTO.ReviewEntradaDTO;
import com.example.spazio.dto.modDTO.ReviewModEntradaDTO;
import com.example.spazio.dto.salidaDTO.ReviewSalidaDTO;

import java.util.List;

public interface iReviewService {
    ReviewSalidaDTO agregarReview(ReviewEntradaDTO reviewEntradaDTO);

    List<ReviewSalidaDTO> listarReviewsPorLugar(Long lugarId);

    ReviewSalidaDTO modificarReview(ReviewModEntradaDTO reviewModificacionDTO);

    void eliminarReview(Long reviewId);
}
