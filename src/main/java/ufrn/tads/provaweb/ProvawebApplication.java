package ufrn.tads.provaweb;

import antlr.BaseAST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ufrn.tads.provaweb.models.Filmes;
import ufrn.tads.provaweb.models.Usuarios;
import ufrn.tads.provaweb.repository.FilmesRepository;
import ufrn.tads.provaweb.repository.UsuariosRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProvawebApplication implements WebMvcConfigurer {

	@Autowired
	private FilmesRepository filmeRepository;
	@Autowired
	private UsuariosRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(ProvawebApplication.class, args);
	}

	@PostConstruct
	public void initFilmes() {

		List<Filmes> filmes = Stream.of(
				new Filmes(3L, "Titulo", "Diretor", "13/06/2022", "50", "filmes.jpg", "sinopse sinopse", 5 ),
				new Filmes(3L, "Titulo", "Diretor", "13/06/2022", "50", "filmes.jpg", "sinopse sinopse", 5 ),
				new Filmes(3L, "Titulo", "Diretor", "13/06/2022", "50", "filmes.jpg", "sinopse sinopse", 5 )

		).collect(Collectors.toList());

		filmeRepository.saveAll(filmes);

		List<Usuarios> usuarios = Stream.of(
				new Usuarios(1L, "admin", encoder().encode("admin"), false, false, false, true, true),
				new Usuarios(2L, "ana", encoder().encode("ana"), false, false, false, true, false),
				new Usuarios(3L, "user2", encoder().encode("user2"), false, false, false, true, false)

		).collect(Collectors.toList());

		repository.saveAll(usuarios);

	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Register resource handler for images
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
				//.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		/*
		registry.addResourceHandler("/images/**").addResourceLocations("/images/")
		.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());*/
	}

	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
