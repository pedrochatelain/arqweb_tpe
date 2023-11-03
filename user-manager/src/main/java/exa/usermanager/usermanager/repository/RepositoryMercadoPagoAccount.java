package exa.usermanager.usermanager.repository;

import exa.usermanager.usermanager.entity.CuentaMercadoPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryMercadoPagoAccount extends JpaRepository<CuentaMercadoPago, Long> {
}
