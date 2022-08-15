package br.edu.infnet.appvendaproduto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendaController {

    @GetMapping(value = "/venda/lista")
    public String telaHome() {
        return "venda/lista";
    }
}
