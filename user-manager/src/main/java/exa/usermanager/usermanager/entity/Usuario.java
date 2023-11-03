package exa.usermanager.usermanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Usuario {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    @ManyToMany(mappedBy = "usuarios")
    private List<CuentaMercadoPago> cuentas;

    @Column
    private String email;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Timestamp fecha_alta;

    public Usuario(String username) {
        this.username = username;
        this.fecha_alta = new Timestamp(System.currentTimeMillis());
    }

}
