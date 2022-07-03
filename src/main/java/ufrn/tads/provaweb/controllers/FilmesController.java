package ufrn.tads.provaweb.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ufrn.tads.provaweb.models.Filmes;
import ufrn.tads.provaweb.models.Usuarios;
import ufrn.tads.provaweb.service.FileStorageService;
import ufrn.tads.provaweb.service.FilmesService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class FilmesController {

    private final FilmesService filmesService;
    private final FileStorageService fileStorageService;

    public Usuarios user;


    public FilmesController(FilmesService filmesService, FileStorageService fileStorageService){
        this.filmesService = filmesService;
        this.fileStorageService = fileStorageService;
    }


    @GetMapping(value = {"/", "/index"})
    public String home(Model model){
        List<Filmes> filmes = filmesService.findAll();
        model.addAttribute("filmes", filmes);

        return "index";
    }

    @GetMapping(value = {"/cadastrar"})
    public String cadastrarFilmes(Model model){

        Filmes f = new Filmes();
        model.addAttribute("filmes", f);
        return "filmes/cadastrar";
    }

    @RequestMapping(value = "/filmes", method = RequestMethod.GET)
    public String verFilmes(Model model){
        List<Filmes> filmes = filmesService.findAll();
        model.addAttribute("filmes", filmes);

        return "filmes/filmes";
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
    public String deletarFilmes(@PathVariable long id){
        filmesService.deletarPorId(id);
        return "redirect:/filmes";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editarFilmes(Model model, @PathVariable long id){
        Filmes filmes = filmesService.buscarPorId(id);
        model.addAttribute("filmes", filmes);
        return "filmes/editar";
    }

    @PostMapping(value = "/salvar")
    public String salvarFilme(@ModelAttribute @Valid Filmes f, Errors errors, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (errors.hasErrors()) {
            System.out.println(errors.getAllErrors().stream().toArray());
            return "filmes/cadastrar";
        } else {

			/*
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getContentType());
			System.out.println(file.getSize());
			*/

            f.setImagemUri(file.getOriginalFilename());
            filmesService.editar(f);
            fileStorageService.save(file);

            redirectAttributes.addAttribute("msg", "Cadastro realizado com sucesso");
            return "filmes/filmes";
        }
    }



}
