package com.example.spazio.dto.entradaDTO;

public class FotoEntradaDTO {

    private String rutaFoto;
    private Long lugar; // ID del lugar al que pertenece la foto

    public FotoEntradaDTO() {
    }

    public FotoEntradaDTO(String rutaFoto, Long lugar) {
        this.rutaFoto = rutaFoto;
        this.lugar = lugar;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public Long getLugarId() {
        return lugar;
    }

    public void setLugarId(Long lugar) {
        this.lugar = lugar;
    }
}

