package exa.usermanager.usermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseAddMercadoPagoAccountToUser {

    private int status_code;
    private String message;

}