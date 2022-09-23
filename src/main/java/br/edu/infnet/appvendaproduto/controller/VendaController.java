package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.service.ProdutoService;
import br.edu.infnet.appvendaproduto.service.ClienteService;
import br.edu.infnet.appvendaproduto.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendaController {

    @Autowired
    VendaService vendaService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;

    @GetMapping(value = "/venda/cadastro")
    public String telaCadastro(Model model) {
        model.addAttribute("clientes", clienteService.obterLista());
        model.addAttribute("produtos", produtoService.obterLista());

        return "venda/cadastro";
    }

    @GetMapping(value = "/venda/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", vendaService.obterLista());

        return "venda/lista";
    }

    @PostMapping("/venda/incluir")
    public String exclusao() {

        return "redirect:/venda/lista";
    }
    @GetMapping("/venda/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        vendaService.excluir(id);

        return "redirect:/venda/lista";
    }
}
