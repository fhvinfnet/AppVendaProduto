package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.*;

@Controller
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    private String mensagem;
    private String tipo;

    @GetMapping(value = "/notebook/lista")
    public String telaHome(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("listagem", notebookService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);

        return "notebook/lista";
    }

    @GetMapping("/notebook/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        try {
            notebookService.excluir(id);

            mensagem = "exclusao realizada com sucesso!";
            tipo = "alert-success";
        } catch (Exception e) {
            mensagem = "impossivel realizar exclusao!";
            tipo = "alert-danger";
        }

        return "redirect:/notebook/lista";
    }
}
