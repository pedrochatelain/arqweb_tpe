package exa.usermanager.usermanager.controller;

import exa.usermanager.usermanager.dto.MercadoPagoAccountCreationResponse;
import exa.usermanager.usermanager.dto.MercadoPagoAccountDTO;
import exa.usermanager.usermanager.service.ServiceMercadoPagoAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mercado-pago-accounts")
public class MercadoPagoAccountController {

    private final ServiceMercadoPagoAccount service;

    @Autowired
    public MercadoPagoAccountController(ServiceMercadoPagoAccount service) {
        this.service = service;
    }

    @PostMapping
    public MercadoPagoAccountCreationResponse createMercadoPagoAccount(@RequestBody MercadoPagoAccountDTO account) {
        return service.createMercadoPagoAccount(account);
    }

}
