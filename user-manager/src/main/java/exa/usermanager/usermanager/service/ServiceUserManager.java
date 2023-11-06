package exa.usermanager.usermanager.service;

import exa.usermanager.usermanager.dto.MercadoPagoAccountDTO;
import exa.usermanager.usermanager.dto.ResponseAddMercadoPagoAccountToUser;
import exa.usermanager.usermanager.dto.ResponseUserCreation;
import exa.usermanager.usermanager.dto.UserDTO;
import exa.usermanager.usermanager.entity.CuentaMercadoPago;
import exa.usermanager.usermanager.entity.Usuario;
import exa.usermanager.usermanager.repository.RepositoryMercadoPagoAccount;
import exa.usermanager.usermanager.repository.RepositoryUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserManager {

    private final RepositoryUserManager repository;
    private final RepositoryMercadoPagoAccount repository_mercado_pago;

    @Autowired
    public ServiceUserManager(RepositoryUserManager repository, RepositoryMercadoPagoAccount repository_mercado_pago) {
        this.repository = repository;
        this.repository_mercado_pago = repository_mercado_pago;
    }

    public ResponseUserCreation createUser(UserDTO user) {
        Usuario userCreated = repository.save(new Usuario(user.getUsername()));
        user.setFecha_alta(userCreated.getFecha_alta());
        return new ResponseUserCreation(HttpStatus.CREATED.value(), "El usuario fue creado exitosamente", user);
    }

    public ResponseAddMercadoPagoAccountToUser addMercadoPagoAccount(int userId, MercadoPagoAccountDTO account_mercado_pago) {
        Usuario user = repository.findById((long) userId).get();
        CuentaMercadoPago mercadoPagoAccount = repository_mercado_pago.findById((long) account_mercado_pago.getId()).get();
        user.addMercadoPagoAccount(mercadoPagoAccount);
        repository.save(user);
        repository_mercado_pago.save(mercadoPagoAccount);
        return new ResponseAddMercadoPagoAccountToUser(HttpStatus.OK.value(), "Se vinculó correctamente la cuenta de mercado pago al usuario");
    }

    public UserDTO getUser(int userId) {
        Usuario user = repository.findById((long) userId).get();
        UserDTO dto = new UserDTO(user.getUsername(), user.getEmail(), user.getNombre(), user.getApellido(), user.getFecha_alta());
        return dto;
    }
}
