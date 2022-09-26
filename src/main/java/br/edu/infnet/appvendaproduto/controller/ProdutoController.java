package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Produto;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.*;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(value = "/produto/lista")
    public String telaLista(Model model, @SessionAttribute("user")Usuario usuario) {
        model.addAttribute("listagem", produtoService.obterLista(usuario));

        return "produto/lista";
    }

    @GetMapping("/produto/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        produtoService.excluir(id);

        return "redirect:/produto/lista";
    }
}
