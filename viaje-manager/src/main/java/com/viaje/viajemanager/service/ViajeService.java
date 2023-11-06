package com.viaje.viajemanager.service;

import com.viaje.viajemanager.config.RestTemplateClient;
import com.viaje.viajemanager.dto.RequestUpdateStatusViaje;
import com.viaje.viajemanager.dto.ResponseViaje;
import com.viaje.viajemanager.dto.ViajeCreationDTO;
import com.viaje.viajemanager.entity.Viaje;
import com.viaje.viajemanager.repository.RepositoryViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public ResponseViaje pausarViaje(int id_viaje, RequestUpdateStatusViaje req) {
        if (isStatusValid(req.getStatus())) {
            int id_monopatin = repository.findById((long) id_viaje).get().getId_monopatin();
            updateStatusMonopatin(id_monopatin, req);
            Viaje viaje = repository.findById((long) id_viaje).get();
            viaje.setUltima_pausa(new Timestamp(System.currentTimeMillis()));
            repository.save(viaje);
            return new ResponseViaje(HttpStatus.OK.value(), "Se pausó correctamente el viaje", viaje);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERROR el valor status solo puede tomar los valores: finalizado, pausado o en camino");
        }
    }

    private boolean isStatusValid(String status) {
        status = status.trim();
        return status.equals("pausado") || status.equals("finalizado") || status.equals("en camino");
    }

    private void updateStatusMonopatin(int id_monopatin, RequestUpdateStatusViaje req) {
        restTemplateClient.getTemplate().postForLocation("http://localhost:8003/api/monopatines/" + id_monopatin + "/status", req);
    }

}
