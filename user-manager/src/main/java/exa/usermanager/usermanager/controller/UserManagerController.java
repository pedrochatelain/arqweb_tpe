package exa.usermanager.usermanager.controller;

import exa.usermanager.usermanager.dto.UserCreationResponse;
import exa.usermanager.usermanager.dto.UserDTO;
import exa.usermanager.usermanager.service.ServiceUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuarios")
public class UserManagerController {

    private final ServiceUserManager service;

    @Autowired
    public UserManagerController(ServiceUserManager service) {
        this.service = service;
    }

    @PostMapping
    public UserCreationResponse createUser(@RequestBody UserDTO user) {
        return service.createUser(user);
    }

}
