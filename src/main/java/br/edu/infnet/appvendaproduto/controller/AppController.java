package br.edu.infnet.appvendaproduto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping(value = "/")
    public String telaHome() {
        return "home";
    }
}
