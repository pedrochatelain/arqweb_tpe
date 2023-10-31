package com.example.monopatinmanager;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/monopatines")
public class Controller {

    @GetMapping()
    public String getMonopatines() {
        return "monopatines!";
    }

}