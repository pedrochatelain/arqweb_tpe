package com.example.monopatinmanager.controller;

import com.example.monopatinmanager.dto.MonopatinCreationResponse;
import com.example.monopatinmanager.dto.MonopatinDTO;
import com.example.monopatinmanager.service.MonopatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/monopatines")
public class Controller {

    private MonopatinService service;

    @Autowired
    public Controller(MonopatinService service) {
        this.service = service;
    }

    @GetMapping()
    public String getMonopatines() {
        return "monopatines!";
    }

    @PostMapping
    public MonopatinCreationResponse saveMonopatin(@RequestBody MonopatinDTO monopatinDTO) {
        return service.saveMonopatin(monopatinDTO);
    }

}