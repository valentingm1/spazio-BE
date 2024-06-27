package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.ReviewEntradaDTO;
import com.example.spazio.dto.modDTO.ReviewModEntradaDTO;
import com.example.spazio.dto.salidaDTO.ReviewSalidaDTO;
import com.example.spazio.entity.Lugar;
import com.example.spazio.entity.Review;
import com.example.spazio.entity.Usuario;
import com.example.spazio.repository.LugarRepository;
import com.example.spazio.repository.ReviewRepository;
import com.example.spazio.repository.UsuarioRepository;
import com.example.spazio.service.iReviewService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements iReviewService {

    private final ReviewRepository reviewRepository;
    private final UsuarioRepository usuarioRepository;
    private final LugarRepository lugarRepository;
    private final ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(LugarService.class);

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UsuarioRepository usuarioRepository, LugarRepository lugarRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.usuarioRepository = usuarioRepository;
        this.lugarRepository = lugarRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ReviewSalidaDTO agregarReview(ReviewEntradaDTO reviewEntradaDTO) {
        Usuario usuario = usuarioRepository.findById(reviewEntradaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Lugar lugar = lugarRepository.findById(reviewEntradaDTO.getLugarId())
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));

        // Verificar si el usuario ha hecho una reserva en el lugar
        boolean tieneReserva = lugar.getReservas().stream()
                .anyMatch(reserva -> reserva.getUsuario().getId().equals(usuario.getId()));

        if (!tieneReserva) {
            throw new RuntimeException("El usuario no puede hacer una review porque no tiene reservas en este lugar");
        }

        Review review = new Review();
        review.setUsuario(usuario);
        review.setLugar(lugar);
        review.setContenido(reviewEntradaDTO.getContenido());

        Review reviewGuardada = reviewRepository.save(review);
        return modelMapper.map(reviewGuardada, ReviewSalidaDTO.class);
    }

    @Override
    public List<ReviewSalidaDTO> listarReviewsPorLugar(Long lugarId) {
        Lugar lugar = lugarRepository.findById(lugarId)
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));

        return lugar.getReviews().stream()
                .map(review -> modelMapper.map(review, ReviewSalidaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewSalidaDTO modificarReview(ReviewModEntradaDTO reviewModificacionDTO) {
        LOGGER.info("Iniciando la modificación de la review con ID: {}", reviewModificacionDTO.getId());

        Review review = reviewRepository.findById(reviewModificacionDTO.getId())
                .orElseThrow(() -> {
                    LOGGER.error("Review no encontrada con ID: {}", reviewModificacionDTO.getId());
                    return new RuntimeException("Review no encontrada");
                });

        LOGGER.info("Actualizando la review con nuevo contenido: {}", reviewModificacionDTO.getContenido());

        review.setContenido(reviewModificacionDTO.getContenido());
        reviewRepository.save(review);

        LOGGER.info("Review con ID: {} modificada exitosamente", reviewModificacionDTO.getId());

        return modelMapper.map(review, ReviewSalidaDTO.class);
    }

    @Override
    public void eliminarReview(Long reviewId) {
        LOGGER.info("Iniciando la eliminación de la review con ID: {}", reviewId);

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> {
                    LOGGER.error("Review no encontrada con ID: {}", reviewId);
                    return new RuntimeException("Review no encontrada");
                });

        reviewRepository.delete(review);

        LOGGER.info("Review con ID: {} eliminada exitosamente", reviewId);
    }
}
