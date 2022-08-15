package br.edu.infnet.appvendaproduto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CelularController {

    @GetMapping(value = "/celular/lista")
    public String telaHome() {
        return "celular/lista";
    }
}
