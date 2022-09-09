package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {

    private static Map<String, Usuario> mapaUsuario = new HashMap<>();

    public Collection<Usuario> obterLista() {
        return mapaUsuario.values();
    }

    public void incluir(Usuario usuario) {
        mapaUsuario.put(usuario.getEmail(), usuario);

        AppImpressao.relatorio(usuario, "inclusao do usuario: " + obterLista());
    }

    public void excluir(String email) {
        mapaUsuario.remove(email);
    }

    public Usuario validarUsuario(String email, String senha) {
        Usuario usuario = mapaUsuario.get(email);

        if (usuario != null && usuario.getSenha().equals(usuario.getSenha())) {
            return usuario;
        }

        return null;
    }

}
