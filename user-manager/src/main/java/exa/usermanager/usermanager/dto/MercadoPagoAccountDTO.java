package exa.usermanager.usermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class MercadoPagoAccountDTO {

    private int id;
    private double monto;
    private Timestamp fecha_alta;

}
