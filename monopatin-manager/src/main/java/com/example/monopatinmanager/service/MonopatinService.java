package com.example.monopatinmanager.service;

import com.example.monopatinmanager.dto.RequestUpdateStatus;
import com.example.monopatinmanager.dto.ResponseDTO;
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

    public ResponseDTO saveMonopatin(MonopatinDTO dto) {
        Monopatin monopatin = repository.save(new Monopatin(dto.getStatus(), dto.getLatitud(), dto.getLongitud()));
        return new ResponseDTO(HttpStatus.CREATED.value(), "Creado exitosamente", monopatin);
    }

    public ResponseDTO updateStatusMonopatin(RequestUpdateStatus request) {
        Monopatin monopatin = repository.getReferenceById((long) request.getId());
        monopatin.setStatus(request.getStatus());
        monopatin = repository.save(monopatin);
        return new ResponseDTO(HttpStatus.OK.value(), "Se ha editado correctamente el status", monopatin);
    }
}
