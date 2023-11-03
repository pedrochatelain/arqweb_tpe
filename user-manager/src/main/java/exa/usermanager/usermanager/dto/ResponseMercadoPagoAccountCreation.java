package exa.usermanager.usermanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseMercadoPagoAccountCreation {

    private int status_code;
    private String message;
    private MercadoPagoAccountDTO account;

}
