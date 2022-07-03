package ufrn.tads.provaweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ufrn.tads.provaweb.models.Filmes;

@Controller
public class UsuariosController {


    @GetMapping("/admin")
    public String admin(){

            return "filmes/lista";

    }
}
