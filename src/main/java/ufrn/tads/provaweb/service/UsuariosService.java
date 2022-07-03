package ufrn.tads.provaweb.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ufrn.tads.provaweb.models.Usuarios;
import ufrn.tads.provaweb.repository.UsuariosRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UsuariosService implements UserDetailsService {

    UsuariosRepository repository;

    UsuariosService(UsuariosRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuarios> optional = repository.findByUsername(username);

        if(optional.isPresent()) {
            return (UserDetails) optional.get();
        }

        throw new UsernameNotFoundException("User not found");
    }
    public Usuarios cadastro(Usuarios U){
        return repository.save(U);
    }

    public Usuarios alterar(Usuarios U){
        return repository.saveAndFlush(U);
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }

    public List<Usuarios> Listall(){
        return repository.findAll();
    }
    public Optional<Usuarios> ListById(Long id){
        return repository.findById(id);
    }
}