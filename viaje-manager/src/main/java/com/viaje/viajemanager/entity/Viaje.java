package com.viaje.viajemanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Viaje {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int id_usuario;

    @Column
    private int id_monopatin;

    @Column
    private Timestamp inicio;

    @Column
    private Timestamp fin;

    @Column
    private double precio;

    @Column
    private double kilometros_recorridos;

    @Column
    private Timestamp ultima_pausa;

}
