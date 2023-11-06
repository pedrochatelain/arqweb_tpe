package com.viaje.viajemanager.service;

import com.viaje.viajemanager.dto.ResponseCreationViaje;
import com.viaje.viajemanager.dto.ViajeCreationDTO;
import com.viaje.viajemanager.entity.Viaje;
import com.viaje.viajemanager.repository.RepositoryViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ViajeService {

    private final RepositoryViaje repository;

    @Autowired
    public ViajeService(RepositoryViaje repository) {
        this.repository = repository;
    }

    public ResponseCreationViaje guardarViaje(ViajeCreationDTO viajeCreationDTO) {
        Viaje viaje = crearViaje(viajeCreationDTO);
        repository.save(viaje);
        return new ResponseCreationViaje(HttpStatus.CREATED.value(), "Se creó correctamente el viaje", viaje);
    }

    private Viaje crearViaje(ViajeCreationDTO dto) {
        return new Viaje(dto.getId_usuario(), dto.getId_monopatin(), new Timestamp(System.currentTimeMillis()));
    }

}
