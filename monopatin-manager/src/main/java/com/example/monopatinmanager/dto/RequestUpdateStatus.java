package com.example.monopatinmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RequestUpdateStatus {

    private int id;
    private String status;

}
