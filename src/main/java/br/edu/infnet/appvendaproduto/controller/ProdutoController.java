package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProdutoController {

    private static List<Produto> produtos = new ArrayList<>();;

    @GetMapping(value = "/produto/lista")
    public String telaHome() {
        return "produto/lista";
    }
}
