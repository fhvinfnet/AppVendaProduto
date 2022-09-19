package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.ImpressoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class ImpressoraController {

    @Autowired
    ImpressoraService impressoraService;

    @GetMapping(value = "/impressora")
    public String telaCadastro() {
        return "impressora/cadastro";
    }

    @GetMapping(value = "/impressora/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", impressoraService.obterLista());

        return "impressora/lista";
    }

    @GetMapping("/impressora/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        impressoraService.excluir(id);

        return "redirect:/impressora/lista";
    }

    @PostMapping("/impressora/incluir")
    public String inclusao(Impressora impressora) {
        impressoraService.incluir(impressora);

        return "redirect:/impressora/lista";
    }
}
