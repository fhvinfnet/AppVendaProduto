package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class NotebookController {

    private static Map<Integer, Notebook> mapaNotebook = new HashMap<>();

    private static Integer id = 1;

    public static Collection<Notebook> obterLista() {
        return mapaNotebook.values();
    }

    public static void incluir(Notebook notebook) {
        notebook.setId(id++);
        mapaNotebook.put(notebook.getId(), notebook);

        AppImpressao.relatorio(notebook, "inclusao do notebook: " + obterLista());
    }

    @GetMapping(value = "/notebook/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", obterLista());

        return "notebook/lista";
    }
}
