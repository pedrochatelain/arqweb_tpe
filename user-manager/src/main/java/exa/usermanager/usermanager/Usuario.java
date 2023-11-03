package exa.usermanager.usermanager;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Usuario {

    @Id
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

}
