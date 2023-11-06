package com.viaje.viajemanager.service;

import com.viaje.viajemanager.config.RestTemplateClient;
import com.viaje.viajemanager.dto.RequestUpdateStatus;
import com.viaje.viajemanager.dto.ResponseViaje;
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
    private final RestTemplateClient restTemplateClient;

    @Autowired
    public ViajeService(RepositoryViaje repository, RestTemplateClient restTemplateClient) {
        this.repository = repository;
        this.restTemplateClient = restTemplateClient;
    }

    public ResponseViaje guardarViaje(ViajeCreationDTO viajeCreationDTO) {
        Viaje viaje = crearViaje(viajeCreationDTO);
        repository.save(viaje);
        return new ResponseViaje(HttpStatus.CREATED.value(), "Se creó correctamente el viaje", viaje);
    }

    private Viaje crearViaje(ViajeCreationDTO dto) {
        return new Viaje(dto.getId_usuario(), dto.getId_monopatin(), new Timestamp(System.currentTimeMillis()));
    }

    public ResponseViaje pausarViaje(RequestUpdateStatus req, int id_viaje) {
        int id_monopatin = repository.getReferenceById((long) id_viaje).getId_monopatin();
        restTemplateClient.getTemplate().postForLocation("http://localhost:8003/api/monopatines/" + id_monopatin + "/status", req);
        Viaje viaje = repository.findById((long) id_viaje).get();
        viaje.setUltima_pausa(new Timestamp(System.currentTimeMillis()));
        repository.save(viaje);
        return new ResponseViaje(HttpStatus.OK.value(), "Se pausó correctamente el viaje", viaje);
    }

}
