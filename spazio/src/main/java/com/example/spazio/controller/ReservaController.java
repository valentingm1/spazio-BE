package com.example.spazio.controller;

import com.example.spazio.dto.entradaDTO.ReservaEntradaDTO;
import com.example.spazio.dto.salidaDTO.ReservaSalidaDTO;
import com.example.spazio.service.iReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin
public class ReservaController {

    private final iReservaService reservaService;

    @Autowired
    public ReservaController(iReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaSalidaDTO> crearReserva(@RequestBody ReservaEntradaDTO reservaEntradaDTO) {
        ReservaSalidaDTO nuevaReserva = reservaService.crearReserva(reservaEntradaDTO);
        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservaSalidaDTO>> listarReservas() {
        List<ReservaSalidaDTO> reservas = reservaService.listarReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaSalidaDTO> obtenerReservaPorId(@PathVariable Long id) {
        ReservaSalidaDTO reserva = reservaService.obtenerReservaPorId(id);
        if (reserva != null) {
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarReserva(@PathVariable Long id) {
        try {
            reservaService.cancelarReserva(id);
            return new ResponseEntity<>("Reserva cancelada correctamente", HttpStatus.OK);
        } catch (RuntimeException e) { // Asegúrate de capturar la excepción adecuada para tu caso
            return new ResponseEntity<>("Reserva no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}