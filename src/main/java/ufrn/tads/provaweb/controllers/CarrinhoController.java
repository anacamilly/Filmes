package ufrn.tads.provaweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ufrn.tads.provaweb.models.Filmes;
import ufrn.tads.provaweb.service.FilmesService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.util.WebUtils.getCookie;

@Controller
public class CarrinhoController {

    private final FilmesService filmesService;

    public CarrinhoController(FilmesService filmesService) {
        this.filmesService = filmesService;
    }


    @PostMapping(value = "/adicionarCarrinho/{id}")
    public void doAdicionarCarrinho(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Filmes filmes = filmesService.buscarPorId(id);

        Cookie carrinho = new Cookie("carrinho", "");
        carrinho.setMaxAge(60*60*24); //24 hour

        Cookie[] requestCookies = request.getCookies();
        boolean achouCarrinho = false;

        if (requestCookies != null) {
            for (var c : requestCookies) {
                if (c.getName().equals("carrinho")) {
                    achouCarrinho = true;
                    carrinho = c;
                    break;
                }
            }
        }

        Filmes produtoEscolhido = null;


            if (achouCarrinho) {
                String value = carrinho.getValue();
                carrinho.setValue(value + produtoEscolhido.getId() + "|");
            } else {
                carrinho.setValue(produtoEscolhido.getId() + "|");
            }

        response.addCookie(carrinho);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/");
        dispatcher.forward(request, response);
    }

    @GetMapping("/finalizarCompra")
    public String finalizarCompra(){
        return "index";
    }

    @GetMapping("/verCarrinho")
    public String verCarrinho(){
        return "carrinho/carrinho";
    }
}