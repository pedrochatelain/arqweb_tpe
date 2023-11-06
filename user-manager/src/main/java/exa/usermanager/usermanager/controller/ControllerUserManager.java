package exa.usermanager.usermanager.controller;

import exa.usermanager.usermanager.dto.MercadoPagoAccountDTO;
import exa.usermanager.usermanager.dto.ResponseAddMercadoPagoAccountToUser;
import exa.usermanager.usermanager.dto.ResponseUserCreation;
import exa.usermanager.usermanager.dto.UserDTO;
import exa.usermanager.usermanager.service.ServiceUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class ControllerUserManager {

    private final ServiceUserManager service;

    @Autowired
    public ControllerUserManager(ServiceUserManager service) {
        this.service = service;
    }

    @PostMapping
    public ResponseUserCreation createUser(@RequestBody UserDTO user) {
        return service.createUser(user);
    }

    @PostMapping("{user_id}")
    public ResponseAddMercadoPagoAccountToUser addMercadoPagoAccount(@PathVariable int user_id, @RequestBody MercadoPagoAccountDTO account_mercado_pago) {
        return service.addMercadoPagoAccount(user_id, account_mercado_pago);
    }

    @GetMapping("{user_id}")
    public UserDTO getUser(@PathVariable int user_id) {
        return service.getUser(user_id);
    }

}
