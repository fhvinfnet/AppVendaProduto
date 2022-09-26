package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.*;

@Controller
public class CelularController {

    @Autowired
    CelularService celularService;

    @GetMapping(value = "/celular")
    public String telaCadastro() {
        return "celular/cadastro";
    }

    @GetMapping(value = "/celular/lista")
    public String telaHome(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("listagem", celularService.obterLista(usuario));
        return "celular/lista";
    }

    @GetMapping("/celular/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        celularService.excluir(id);

        return "redirect:/celular/lista";
    }

    @PostMapping("/celular/incluir")
    public String inclusao(Celular celular, @SessionAttribute("user") Usuario usuario) {
        celular.setUsuario(usuario);

        celularService.incluir(celular);

        return "redirect:/celular/lista";
    }
}
