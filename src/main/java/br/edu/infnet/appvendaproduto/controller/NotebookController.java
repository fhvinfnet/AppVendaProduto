package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NotebookController {

    private static List<Notebook> notebooks = new ArrayList<>();;

    @GetMapping(value = "/notebook/lista")
    public String telaHome() {
        return "notebook/lista";
    }
}
