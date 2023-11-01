package com.example.monopatinmanager.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/monopatines")
public class Controller {

    @GetMapping()
    public String getMonopatines() {
        return "monopatines!";
    }

}