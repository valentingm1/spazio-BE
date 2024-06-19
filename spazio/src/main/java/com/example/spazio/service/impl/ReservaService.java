package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.ReservaEntradaDTO;
import com.example.spazio.dto.salidaDTO.ReservaSalidaDTO;
import com.example.spazio.entity.Reserva;
import com.example.spazio.entity.Usuario;
import com.example.spazio.entity.Lugar;
import com.example.spazio.repository.ReservaRepository;
import com.example.spazio.repository.UsuarioRepository;
import com.example.spazio.repository.LugarRepository;
import com.example.spazio.service.iReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService implements iReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final LugarRepository lugarRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, LugarRepository lugarRepository, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.lugarRepository = lugarRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReservaSalidaDTO crearReserva(ReservaEntradaDTO reservaEntradaDTO) {
        Usuario usuario = usuarioRepository.findById(reservaEntradaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Lugar lugar = lugarRepository.findById(reservaEntradaDTO.getLugarId())
                .orElseThrow(() -> new RuntimeException("Lugar no encontrado"));

        if (reservaEntradaDTO.getHoraFin().isBefore(reservaEntradaDTO.getHoraInicio())) {
            throw new RuntimeException("La hora de fin debe ser posterior a la hora de inicio");
        }

        // Validar que no haya conflictos de reserva para el mismo lugar y horario
        List<Reserva> reservasExistentes = reservaRepository.findByLugarId(reservaEntradaDTO.getLugarId());
        for (Reserva reserva : reservasExistentes) {
            if (reserva.getFecha().isEqual(reservaEntradaDTO.getFecha()) &&
                    reservaEntradaDTO.getHoraInicio().isBefore(reserva.getHoraFin()) &&
                    reservaEntradaDTO.getHoraFin().isAfter(reserva.getHoraInicio())) {
                throw new RuntimeException("Conflicto de reserva para el mismo lugar y horario");
            }
        }

        Reserva reserva = new Reserva(
                usuario,
                lugar,
                reservaEntradaDTO.getFecha(),
                reservaEntradaDTO.getHoraInicio(),
                reservaEntradaDTO.getHoraFin()
        );

        Reserva reservaGuardada = reservaRepository.save(reserva);

        return modelMapper.map(reservaGuardada, ReservaSalidaDTO.class);
    }

    @Override
    public List<ReservaSalidaDTO> listarReservas() {
        return reservaRepository.findAll().stream()
                .map(reserva -> modelMapper.map(reserva, ReservaSalidaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservaSalidaDTO obtenerReservaPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return modelMapper.map(reserva, ReservaSalidaDTO.class);
    }

    @Override
    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reservaRepository.delete(reserva);
    }
}
