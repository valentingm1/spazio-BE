package com.example.spazio.service.impl;

import com.example.spazio.repository.FotoRepository;
import com.example.spazio.service.iFotoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FotoService implements iFotoService {
    private final FotoRepository FotoRepository;
    private final ModelMapper ModelMapper;

    public FotoService(com.example.spazio.repository.FotoRepository fotoRepository, ModelMapper modelmapper) {
        FotoRepository = fotoRepository;
        ModelMapper = modelmapper;
    }


}
