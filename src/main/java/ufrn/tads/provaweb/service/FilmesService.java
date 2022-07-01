package ufrn.tads.provaweb.service;
import org.springframework.stereotype.Service;
import ufrn.tads.provaweb.models.Filmes;
import ufrn.tads.provaweb.repository.FilmesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    private final FilmesRepository repository;

    public FilmesService(FilmesRepository repository) {
        this.repository = repository;
    }

    public Filmes cadastrar(Filmes f){
        return repository.save(f);
    }

    public void deletarPorId(Long id){
        repository.deleteById(id);
    }

    public Filmes editar(Filmes f){
        return repository.saveAndFlush(f);
    }

    public Filmes buscarPorId(Long id){
        Optional<Filmes> FilmesOptional = repository.findById(id);
        return FilmesOptional.orElse(null);
    }

    public List<Filmes> findAll(){
        return repository.findAll();
    }
}