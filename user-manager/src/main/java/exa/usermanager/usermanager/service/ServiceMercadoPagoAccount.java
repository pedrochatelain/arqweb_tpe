package exa.usermanager.usermanager.service;

import exa.usermanager.usermanager.dto.ResponseMercadoPagoAccountCreation;
import exa.usermanager.usermanager.dto.MercadoPagoAccountDTO;
import exa.usermanager.usermanager.entity.CuentaMercadoPago;
import exa.usermanager.usermanager.repository.RepositoryMercadoPagoAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ServiceMercadoPagoAccount {

    private final RepositoryMercadoPagoAccount repository;

    @Autowired
    public ServiceMercadoPagoAccount(RepositoryMercadoPagoAccount repository) {
        this.repository = repository;
    }


    public ResponseMercadoPagoAccountCreation createMercadoPagoAccount(MercadoPagoAccountDTO account) {
        repository.save(new CuentaMercadoPago(account.getId(), account.getFecha_alta(), account.getMonto()));
        account.setFecha_alta(new Timestamp(System.currentTimeMillis()));
        return new ResponseMercadoPagoAccountCreation(HttpStatus.CREATED.value(), "Se ha creado la cuenta exitosamente", account);
    }
}
