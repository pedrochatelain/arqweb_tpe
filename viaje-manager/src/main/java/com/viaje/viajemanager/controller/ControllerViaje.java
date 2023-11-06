package com.viaje.viajemanager.controller;

import com.viaje.viajemanager.config.RestTemplateClient;
import com.viaje.viajemanager.dto.RequestUpdateStatus;
import com.viaje.viajemanager.dto.ResponseViaje;
import com.viaje.viajemanager.dto.ViajeCreationDTO;
import com.viaje.viajemanager.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/viajes")
public class ControllerViaje {
    private final ViajeService viajeService;

    @Autowired
    public ControllerViaje(RestTemplateClient restTemplateClient, ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public String defaultRoute() {
        return "viajes controller works!";
    }

    @PostMapping
    public ResponseViaje guardarViaje(@RequestBody ViajeCreationDTO viajeCreationDTO) {
        return viajeService.guardarViaje(viajeCreationDTO);
    }

    @PatchMapping("{id_viaje}")
    public ResponseViaje pausarViaje(@RequestBody RequestUpdateStatus req, @PathVariable int id_viaje) {
        return viajeService.pausarViaje(req, id_viaje);
    }


}
