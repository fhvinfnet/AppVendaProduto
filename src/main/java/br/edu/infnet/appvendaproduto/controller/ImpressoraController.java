package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ImpressoraController {

    private static List<Impressora> impressoras = new ArrayList<>();;

    @GetMapping(value = "/impressora/lista")
    public String telaHome() {
        return "impressora/lista";
    }
}
