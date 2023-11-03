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
public class CuentaMercadoPago {

    @Id
    private int id;

    @Column
    private double monto;

    @Column
    private Timestamp fecha_alta;

    @Column
    @ManyToMany
    @JoinTable(
        name = "cuentas_usuarios",
        joinColumns = { @JoinColumn(name = "usuario_id") },
        inverseJoinColumns = { @JoinColumn(name = "cuenta_mercado_pago_id") }
    )
    private List<Usuario> usuarios;

}
