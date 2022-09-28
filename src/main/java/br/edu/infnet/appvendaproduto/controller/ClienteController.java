package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClienteController {

    private String mensagem;
    private String tipo;

    @Autowired
    ClienteService clienteService;

    @GetMapping(value = "/cliente/lista")
    public String telaHome(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("listagem", clienteService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);

        return "cliente/lista";
    }

    @GetMapping(value = "/cliente")
    public String telaCadastro() {
        return "cliente/cadastro";
    }

    @GetMapping("/cliente/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        try {
            clienteService.excluir(id);

            mensagem = "exclusao realizada com sucesso!";
            tipo = "alert-success";
        } catch (Exception e) {
            mensagem = "impossivel realizar exclusao!";
            tipo = "alert-danger";
        }

        return "redirect:/cliente/lista";
    }

    @PostMapping("/cliente/incluir")
    public String inclusao(Cliente cliente, @SessionAttribute("user") Usuario usuario) {
        cliente.setUsuario(usuario);

        clienteService.incluir(cliente);

        mensagem = "inclusao realizada com sucesso!";
        tipo = "alert-success";

        return "redirect:/cliente/lista";
    }
}
