package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.SolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class ClienteController {

    @Autowired
    SolicitanteService solicitanteService;

    @GetMapping(value = "/cliente/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", solicitanteService.obterLista());

        return "cliente/lista";
    }

    @GetMapping(value = "/cliente")
    public String telaCadastro() {
        return "cliente/cadastro";
    }

    @GetMapping("/cliente/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        solicitanteService.excluir(id);

        return "redirect:/cliente/lista";
    }

    @PostMapping("/cliente/incluir")
    public String inclusao(Cliente cliente) {
        solicitanteService.incluir(cliente);

        return "redirect:/cliente/lista";
    }
}
