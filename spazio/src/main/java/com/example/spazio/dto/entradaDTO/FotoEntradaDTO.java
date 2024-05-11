package com.example.spazio.dto.entradaDTO;

import java.util.List;

public class FotoEntradaDTO {
    private LugarEntradaDTO LugarEntradaDTO;
    private List<String> fotos;

    public FotoEntradaDTO() {
    }

    public FotoEntradaDTO(com.example.spazio.dto.entradaDTO.LugarEntradaDTO lugarEntradaDTO, List<String> fotos) {
        LugarEntradaDTO = lugarEntradaDTO;
        this.fotos = fotos;
    }

    public com.example.spazio.dto.entradaDTO.LugarEntradaDTO getLugarEntradaDTO() {
        return LugarEntradaDTO;
    }

    public void setLugarEntradaDTO(com.example.spazio.dto.entradaDTO.LugarEntradaDTO lugarEntradaDTO) {
        LugarEntradaDTO = lugarEntradaDTO;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }
}


