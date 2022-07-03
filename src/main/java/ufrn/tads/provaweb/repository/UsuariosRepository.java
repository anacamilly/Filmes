package ufrn.tads.provaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.tads.provaweb.models.Usuarios;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByUsername(String username);
}