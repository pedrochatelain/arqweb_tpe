package com.example.monopatinmanager.service;

import com.example.monopatinmanager.dto.MonopatinCreationResponse;
import com.example.monopatinmanager.dto.MonopatinDTO;
import com.example.monopatinmanager.entity.Monopatin;
import com.example.monopatinmanager.repository.MonopatinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MonopatinService {

    private MonopatinRepository repository;

    @Autowired
    public MonopatinService(MonopatinRepository repository) {
        this.repository = repository;
    }

    public MonopatinCreationResponse saveMonopatin(MonopatinDTO dto) {
        Monopatin monopatin = repository.save(new Monopatin(dto.getStatus(), dto.getLatitud(), dto.getLongitud()));
        return new MonopatinCreationResponse(HttpStatus.CREATED.value(), "Creado exitosamente", monopatin);
    }

}
