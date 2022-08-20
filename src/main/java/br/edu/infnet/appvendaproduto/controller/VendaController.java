package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Venda;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VendaController {

    private static List<Venda> vendas = new ArrayList<>();;

    @GetMapping(value = "/venda/lista")
    public String telaHome() {
        return "venda/lista";
    }
}
