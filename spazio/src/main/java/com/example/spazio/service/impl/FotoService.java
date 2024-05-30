package com.example.spazio.service.impl;

import com.example.spazio.dto.entradaDTO.FotoEntradaDTO;
import com.example.spazio.dto.salidaDTO.FotoSalidaDTO;
import com.example.spazio.entity.Foto;
import com.example.spazio.repository.FotoRepository;
import com.example.spazio.service.iFotoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FotoService implements iFotoService {
    private final FotoRepository fotoRepository;
    private final ModelMapper modelMapper;

    public FotoService(FotoRepository fotoRepository, ModelMapper modelMapper) {
        this.fotoRepository = fotoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    private void configureMapping() {
        modelMapper.typeMap(FotoEntradaDTO.class, Foto.class)
                .addMapping(FotoEntradaDTO::getLugarId, Foto::setLugar);
        modelMapper.typeMap(Foto.class, FotoSalidaDTO.class)
                .addMapping(src -> src.getLugar().getId(), FotoSalidaDTO::setLugar);
    }



    @Override
    public FotoSalidaDTO agregarFoto(FotoEntradaDTO foto) {
        Foto fotoEntity = modelMapper.map(foto, Foto.class);
        Foto fotoGuardada = fotoRepository.save(fotoEntity);
        return modelMapper.map(fotoGuardada, FotoSalidaDTO.class);
    }


}
