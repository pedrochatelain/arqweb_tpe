package exa.usermanager.usermanager.service;

import exa.usermanager.usermanager.dto.UserCreationResponse;
import exa.usermanager.usermanager.dto.UserDTO;
import exa.usermanager.usermanager.entity.Usuario;
import exa.usermanager.usermanager.repository.RepositoryUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserManager {

    private final RepositoryUserManager repository;

    @Autowired
    public ServiceUserManager(RepositoryUserManager repository) {
        this.repository = repository;
    }

    public UserCreationResponse createUser(UserDTO user) {
        Usuario userCreated = repository.save(new Usuario(user.getUsername()));
        user.setFecha_alta(userCreated.getFecha_alta());
        return new UserCreationResponse(HttpStatus.CREATED.value(), "El usuario fue creado exitosamente", user);
    }

}
