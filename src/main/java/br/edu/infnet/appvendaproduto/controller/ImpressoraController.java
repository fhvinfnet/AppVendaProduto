package br.edu.infnet.appvendaproduto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImpressoraController {

    @GetMapping(value = "/impressora/lista")
    public String telaHome() {
        return "impressora/lista";
    }
}
