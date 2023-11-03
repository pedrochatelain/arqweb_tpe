package exa.usermanager.usermanager.controller;

import exa.usermanager.usermanager.dto.ResponseMercadoPagoAccountCreation;
import exa.usermanager.usermanager.dto.MercadoPagoAccountDTO;
import exa.usermanager.usermanager.service.ServiceMercadoPagoAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mercado-pago-accounts")
public class ControllerMercadoPagoAccount {

    private final ServiceMercadoPagoAccount service;

    @Autowired
    public ControllerMercadoPagoAccount(ServiceMercadoPagoAccount service) {
        this.service = service;
    }

    @PostMapping
    public ResponseMercadoPagoAccountCreation createMercadoPagoAccount(@RequestBody MercadoPagoAccountDTO account) {
        return service.createMercadoPagoAccount(account);
    }

}
