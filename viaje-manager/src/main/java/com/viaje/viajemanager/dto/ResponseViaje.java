package com.viaje.viajemanager.dto;

import com.viaje.viajemanager.entity.Viaje;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseViaje {

    private int status_code;
    private String message;
    private Viaje viaje;

    public ResponseViaje(int status_code, String message, Viaje viaje) {
        this.status_code = status_code;
        this.message = message;
        this.viaje = viaje;
    }
}
