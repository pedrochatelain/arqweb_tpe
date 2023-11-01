package com.example.monopatinmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
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


}
