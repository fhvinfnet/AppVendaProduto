package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private String mensagem;
    private String tipo;

    @GetMapping(value = "/usuario/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", usuarioService.obterLista());
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);

        return "usuario/lista";
    }

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        usuarioService.incluir(usuario);

        return "redirect:/";
    }

    @GetMapping(value = "/usuario/{email}/excluir")
    public String excluir(@PathVariable String email) {
        try {
            usuarioService.excluir(email);

            mensagem = "exclusao realizada com sucesso!";
            tipo = "alert-success";
        } catch (Exception e) {
            mensagem = "impossivel realizar exclusao!";
            tipo = "alert-danger";
        }

        return "redirect:/usuario/lista";
    }

}
