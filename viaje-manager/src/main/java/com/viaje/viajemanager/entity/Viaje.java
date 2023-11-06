package com.viaje.viajemanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Getter
public class Viaje {

    @Id
    @GeneratedValue
    private int id_viaje;

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

    public Viaje(int id_usuario, int id_monopatin, Timestamp inicio) {
        this.id_usuario = id_usuario;
        this.id_monopatin = id_monopatin;
        this.inicio = inicio;
    }
}
