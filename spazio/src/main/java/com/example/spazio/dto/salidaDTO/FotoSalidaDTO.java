package com.example.spazio.dto.salidaDTO;

public class FotoSalidaDTO {
    private Long id;
    private String rutaFoto;
    private Long lugar_id; // ID del lugar al que pertenece la foto

    public FotoSalidaDTO() {
    }

    public FotoSalidaDTO(Long id, String rutaFoto) {
        this.id = id;
        this.rutaFoto = rutaFoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public Long getLugar() {
        return lugar_id;
    }

    public void setLugar(Long lugar_id) {
        this.lugar_id = lugar_id;
    }
}
