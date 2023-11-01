package com.example.monopatinmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Monopatin {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String status;

    @Column
    private double latitud;

    @Column
    private double longitud;

    public Monopatin(String status, double latitud, double longitud) {
        this.status = status;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
