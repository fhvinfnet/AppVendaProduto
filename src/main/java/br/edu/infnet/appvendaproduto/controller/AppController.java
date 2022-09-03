package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @GetMapping(value = "/")
    public String telaHome() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }
    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = UsuarioController.validarUsuario(email, senha);

        if (usuario != null) {
            String nome = usuario.getNome();

            model.addAttribute("user", nome);
            return "home";
        }

        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(Model model) {
        model.addAttribute("user", "");

        return "redirect:/";
    }
}
