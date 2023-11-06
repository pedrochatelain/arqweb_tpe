package com.example.monopatinmanager.controller;

import com.example.monopatinmanager.dto.RequestUpdateStatus;
import com.example.monopatinmanager.dto.ResponseDTO;
import com.example.monopatinmanager.dto.MonopatinDTO;
import com.example.monopatinmanager.dto.StatusDTO;
import com.example.monopatinmanager.entity.Monopatin;
import com.example.monopatinmanager.service.MonopatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/monopatines")
public class ControllerMonopatin {

    private MonopatinService service;

    @Autowired
    public ControllerMonopatin(MonopatinService service) {
        this.service = service;
    }

    @GetMapping()
    public String getMonopatines() {
        return "monopatines!";
    }

    @PostMapping
    public ResponseDTO saveMonopatin(@RequestBody MonopatinDTO monopatinDTO) {
        return service.saveMonopatin(monopatinDTO);
    }

    @PostMapping("{id_monopatin}/status")
    public ResponseDTO updateStatus(@RequestBody RequestUpdateStatus request, @PathVariable int id_monopatin) {
        return service.updateStatusMonopatin(id_monopatin, request);
    }

    @GetMapping(params = "status")
    public List<Monopatin> getMonopatines(@RequestParam String status) {
        return service.getMonopatines(status);
    }

    @GetMapping(path = "status")
    public List<StatusDTO> getStatusMonopatines() {
        return service.getStatusMonopatines();
    }

}