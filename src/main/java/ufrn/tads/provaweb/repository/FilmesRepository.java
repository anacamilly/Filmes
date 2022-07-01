package ufrn.tads.provaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.tads.provaweb.models.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {
}