package com.example.spazio.service;

import com.example.spazio.dto.entradaDTO.ReservaEntradaDTO;
import com.example.spazio.dto.salidaDTO.ReservaSalidaDTO;

import java.util.List;

public interface iReservaService {
    ReservaSalidaDTO crearReserva(ReservaEntradaDTO reservaEntradaDTO);

    List<ReservaSalidaDTO> listarReservas();

    ReservaSalidaDTO obtenerReservaPorId(Long id);

    void cancelarReserva(Long id);
}
