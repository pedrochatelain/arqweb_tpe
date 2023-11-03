package exa.usermanager.usermanager.repository;

import exa.usermanager.usermanager.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUserManager extends JpaRepository<Usuario, Long> {
}
