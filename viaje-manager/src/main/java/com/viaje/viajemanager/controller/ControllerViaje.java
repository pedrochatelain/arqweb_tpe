package com.viaje.viajemanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/viajes")
public class ControllerViaje {

    @GetMapping
    public String defaultRoute() {
        return "viajes controller works!";
    }

}
