package exa.usermanager.usermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

    private String username;
    private String email;
    private String nombre;
    private String apellido;
    private Timestamp fecha_alta;

}
