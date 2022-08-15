package br.edu.infnet.appvendaproduto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotebookController {

    @GetMapping(value = "/notebook/lista")
    public String telaHome() {
        return "notebook/lista";
    }
}
