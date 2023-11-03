package exa.usermanager.usermanager.entity;

import exa.usermanager.usermanager.dto.MercadoPagoAccountDTO;
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
    @ManyToMany
    @JoinTable(
        name = "cuenta_mercado_pago_usuario",
        joinColumns = { @JoinColumn(name = "id_usuario") },
        inverseJoinColumns = { @JoinColumn(name = "id_cuenta_mercado_pago") }
    )
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

    public void addMercadoPagoAccount(CuentaMercadoPago accountMercadoPago) {
        cuentas.add(accountMercadoPago);
    }
}
