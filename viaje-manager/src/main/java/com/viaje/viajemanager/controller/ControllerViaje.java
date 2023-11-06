package com.viaje.viajemanager.controller;

import com.viaje.viajemanager.config.RestTemplateClient;
import com.viaje.viajemanager.dto.ResponseCreationViaje;
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
    public ResponseCreationViaje guardarViaje(@RequestBody ViajeCreationDTO viajeCreationDTO) {
        return viajeService.guardarViaje(viajeCreationDTO);
    }

}
