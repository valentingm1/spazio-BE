package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.RatingEntradaDTO;
import com.example.spazio.dto.modDTO.RatingModEntradaDTO;
import com.example.spazio.dto.salidaDTO.RatingSalidaDTO;
import com.example.spazio.entity.Rating;
import com.example.spazio.entity.Reserva;
import com.example.spazio.entity.Usuario;
import com.example.spazio.entity.Lugar;
import com.example.spazio.repository.RatingRepository;
import com.example.spazio.repository.ReservaRepository;
import com.example.spazio.repository.UsuarioRepository;
import com.example.spazio.repository.LugarRepository;
import com.example.spazio.service.iRatingService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService implements iRatingService {

    private final RatingRepository ratingRepository;
    private final UsuarioRepository usuarioRepository;
    private final LugarRepository lugarRepository;
    private final ReservaRepository reservaRepository;
    private final ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    public RatingService(RatingRepository ratingRepository, UsuarioRepository usuarioRepository, LugarRepository lugarRepository, ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.ratingRepository = ratingRepository;
        this.usuarioRepository = usuarioRepository;
        this.lugarRepository = lugarRepository;
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RatingSalidaDTO agregarRating(RatingEntradaDTO ratingEntradaDTO) {
        LOGGER.info("Iniciando el proceso de agregar o actualizar rating para Usuario ID: {} y Lugar ID: {}",
                ratingEntradaDTO.getUsuarioId(), ratingEntradaDTO.getLugarId());

        // Buscar usuario
        Usuario usuario = usuarioRepository.findById(ratingEntradaDTO.getUsuarioId())
                .orElseThrow(() -> {
                    LOGGER.error("Usuario no encontrado con ID: {}", ratingEntradaDTO.getUsuarioId());
                    return new RuntimeException("Usuario no encontrado");
                });

        // Buscar lugar
        Lugar lugar = lugarRepository.findById(ratingEntradaDTO.getLugarId())
                .orElseThrow(() -> {
                    LOGGER.error("Lugar no encontrado con ID: {}", ratingEntradaDTO.getLugarId());
                    return new RuntimeException("Lugar no encontrado");
                });

        LOGGER.info("Verificando reservas para el Usuario ID: {} y Lugar ID: {}", usuario.getId(), lugar.getId());

        // Verificar si el usuario tiene al menos una reserva para este lugar
        List<Reserva> reservas = reservaRepository.findReservasByUsuarioIdAndLugarId(usuario.getId(), lugar.getId());
        if (reservas.isEmpty()) {
            LOGGER.warn("El Usuario ID: {} no tiene reservas para el Lugar ID: {}. No se puede agregar rating.",
                    usuario.getId(), lugar.getId());
            throw new RuntimeException("El usuario debe tener al menos una reserva para calificar este lugar");
        }

        // Verificar si ya existe un rating para este usuario y lugar
        Rating ratingExistente = ratingRepository.findByUsuarioIdAndLugarId(usuario.getId(), lugar.getId());
        if (ratingExistente != null) {
            // Si existe, actualizar el rating existente
            LOGGER.info("El rating ya existe para el Usuario ID: {} y Lugar ID: {}. Actualizando el rating.",
                    usuario.getId(), lugar.getId());
            ratingExistente.setRating(ratingEntradaDTO.getRating());
            ratingRepository.save(ratingExistente);
            LOGGER.info("Rating actualizado exitosamente. ID del Rating: {}, Rating: {}",
                    ratingExistente.getId(), ratingExistente.getRating());
            return modelMapper.map(ratingExistente, RatingSalidaDTO.class);
        } else {
            // Si no existe, crear y guardar el nuevo rating
            Rating nuevoRating = new Rating();
            nuevoRating.setUsuario(usuario);
            nuevoRating.setLugar(lugar);
            nuevoRating.setRating(ratingEntradaDTO.getRating());

            Rating savedRating = ratingRepository.save(nuevoRating);
            LOGGER.info("Rating guardado exitosamente. ID del Rating: {}, Rating: {}",
                    savedRating.getId(), savedRating.getRating());

            return modelMapper.map(savedRating, RatingSalidaDTO.class);
        }
    }

    @Override
    public float obtenerPromedioRating(Long lugarId) {
        LOGGER.info("Calculando el promedio de ratings para el Lugar ID: {}", lugarId);

        List<Rating> ratings = ratingRepository.findByLugarId(lugarId);
        if (ratings.isEmpty()) {
            LOGGER.info("No hay ratings disponibles para el Lugar ID: {}", lugarId);
            return 0.0f;
        }

        float sum = (float) ratings.stream()
                .mapToDouble(Rating::getRating)
                .sum();

        float average = sum / ratings.size();
        LOGGER.info("Promedio de ratings calculado para el Lugar ID: {}: {}", lugarId, average);
        return average;
    }

    @Override
    public List<RatingSalidaDTO> listarRatingsPorLugar(Long lugarId) {
        LOGGER.info("Listando todos los ratings para el Lugar ID: {}", lugarId);

        List<Rating> ratings = ratingRepository.findByLugarId(lugarId);

        List<RatingSalidaDTO> ratingsDTO = ratings.stream()
                .map(rating -> modelMapper.map(rating, RatingSalidaDTO.class))
                .collect(Collectors.toList());

        LOGGER.info("Se encontraron {} ratings para el Lugar ID: {}", ratingsDTO.size(), lugarId);
        return ratingsDTO;
    }


    // Método para eliminar un rating
    @Override
    public void eliminarRating(Long ratingId) {
        LOGGER.info("Iniciando la eliminación del rating con ID: {}", ratingId);

        Rating rating = ratingRepository.findById(ratingId)
                .orElseThrow(() -> {
                    LOGGER.error("Rating no encontrado con ID: {}", ratingId);
                    return new RuntimeException("Rating no encontrado");
                });

        ratingRepository.delete(rating);

        LOGGER.info("Rating con ID: {} eliminado exitosamente", ratingId);
    }

    @Override
    public RatingSalidaDTO modificarRating(RatingModEntradaDTO ratingModificacionDTO) {
        LOGGER.info("Iniciando la modificación del rating con ID: {}", ratingModificacionDTO.getId());

        Rating rating = ratingRepository.findById(ratingModificacionDTO.getId())
                .orElseThrow(() -> {
                    LOGGER.error("Rating no encontrado con ID: {}", ratingModificacionDTO.getId());
                    return new RuntimeException("Rating no encontrado");
                });

        LOGGER.info("Actualizando el rating con nuevo valor: {}", ratingModificacionDTO.getRating());

        rating.setRating(ratingModificacionDTO.getRating());
        ratingRepository.save(rating);

        LOGGER.info("Rating con ID: {} modificado exitosamente", ratingModificacionDTO.getId());

        return modelMapper.map(rating, RatingSalidaDTO.class);
    }

}