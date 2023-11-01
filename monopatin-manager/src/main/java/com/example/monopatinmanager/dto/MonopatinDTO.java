package com.example.monopatinmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonopatinDTO {

    private String status;
    private Double latitud;
    private Double longitud;

}
