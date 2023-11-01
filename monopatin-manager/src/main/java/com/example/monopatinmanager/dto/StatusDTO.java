package com.example.monopatinmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatusDTO {

    private String status;
    private Long cantidad_monopatines;

}
