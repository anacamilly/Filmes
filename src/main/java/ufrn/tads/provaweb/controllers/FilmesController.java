package ufrn.tads.provaweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ufrn.tads.provaweb.models.Filmes;
import ufrn.tads.provaweb.service.FilmesService;

import java.util.List;

@Controller
public class FilmesController {

    private final FilmesService filmesService;

    public FilmesController(FilmesService filmesService){
        this.filmesService = filmesService;
    }


    @GetMapping(value = {"/", "/index"})
    public String home(Model model){
        List<Filmes> filmes = filmesService.findAll();
        model.addAttribute("filmes", filmes);

        return "index";
    }
}
