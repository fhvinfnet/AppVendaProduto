package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
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

    private static Map<String, Usuario> mapaUsuario = new HashMap<>();

    public static Collection<Usuario> obterLista() {
        return mapaUsuario.values();
    }

    public static void incluir(Usuario usuario) {
        mapaUsuario.put(usuario.getEmail(), usuario);

        AppImpressao.relatorio(usuario, "inclusao do usuario: " + obterLista());
    }

    public static void excluir(String email) {
        mapaUsuario.remove(email);
    }

    public static Usuario validarUsuario(String email, String senha) {
        Usuario usuario = mapaUsuario.get(email);

        if (usuario != null && usuario.getSenha().equals(usuario.getSenha())) {
            return usuario;
        }

        return null;
    }

    @GetMapping(value = "/usuario/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", mapaUsuario.values());
        return "usuario/lista";
    }

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluirUsuario(Usuario usuario) {
        incluir(usuario);

        return "redirect:/";
    }

    @GetMapping(value = "/usuario/{email}/excluir")
    public String excluirUsuario(@PathVariable String email) {
        excluir(email);
        
        return "redirect:/usuario/lista";
    }

}
