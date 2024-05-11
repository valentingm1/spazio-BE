package com.example.spazio.dto.salidaDTO;

public class FotoSalidaDTO {
    private Long id;
    private String route;
    private LugarSalidaDTO lugarSalidaDTO;


    public FotoSalidaDTO(Long id, String route, LugarSalidaDTO lugarSalidaDTO) {
        this.id = id;
        this.route = route;
        this.lugarSalidaDTO = lugarSalidaDTO;
    }

    public FotoSalidaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public LugarSalidaDTO getLugarSalidaDTO() {
        return lugarSalidaDTO;
    }

    public void setLugarSalidaDTO(LugarSalidaDTO lugarSalidaDTO) {
        this.lugarSalidaDTO = lugarSalidaDTO;
    }
}
