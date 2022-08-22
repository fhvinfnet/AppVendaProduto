package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NotebookController {

    private static List<Notebook> notebooks = new ArrayList<>();;

    public static void incluir(Notebook notebook) {
        notebooks.add(notebook);
        AppImpressao.relatorio(notebook, "inclusao do celular: " + notebook.getNome());
    }

    @GetMapping(value = "/notebook/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", notebooks);

        return "notebook/lista";
    }
}
