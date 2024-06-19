package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.ReservaEntradaDTO;
import com.example.spazio.dto.salidaDTO.ReservaSalidaDTO;
import com.example.spazio.service.iReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final iReservaService reservaService;

    @Autowired
    public ReservaController(iReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ReservaSalidaDTO crearReserva(@RequestBody ReservaEntradaDTO reservaEntradaDTO) {
        return reservaService.crearReserva(reservaEntradaDTO);
    }

    @GetMapping
    public List<ReservaSalidaDTO> listarReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ReservaSalidaDTO obtenerReservaPorId(@PathVariable Long id) {
        return reservaService.obtenerReservaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
    }
}