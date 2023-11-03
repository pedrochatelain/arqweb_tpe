package exa.usermanager.usermanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class CuentaMercadoPago {

    @Id
    private int id;

    @Column
    private double monto;

    @Column
    private Timestamp fecha_alta;

    @Column
    @ManyToMany(mappedBy = "cuentas")
    private List<Usuario> usuarios;

    public CuentaMercadoPago(int id, Timestamp fecha_alta, double monto) {
        this.id = id;
        this.fecha_alta = fecha_alta;
        this.monto = monto;
    }

    public void addUser(Usuario user) {
        usuarios.add(user);
    }
}
