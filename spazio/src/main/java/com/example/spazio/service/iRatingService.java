package com.example.spazio.service;

import com.example.spazio.dto.entradaDTO.RatingEntradaDTO;
import com.example.spazio.dto.modDTO.RatingModEntradaDTO;
import com.example.spazio.dto.salidaDTO.RatingSalidaDTO;

import java.util.List;

public interface iRatingService {
    RatingSalidaDTO agregarRating(RatingEntradaDTO ratingEntradaDTO);

    float obtenerPromedioRating(Long lugarId);

    List<RatingSalidaDTO> listarRatingsPorLugar(Long lugarId);

    RatingSalidaDTO modificarRating(RatingModEntradaDTO ratingModificacionDTO);

    void eliminarRating(Long ratingId);
}
