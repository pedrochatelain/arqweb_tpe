package com.example.monopatinmanager.dto;

import com.example.monopatinmanager.entity.Monopatin;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDTO {

    private int status_code;
    private String message;
    private Monopatin monopatin;

}
