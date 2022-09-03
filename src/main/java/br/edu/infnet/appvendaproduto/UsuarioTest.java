package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.controller.UsuarioController;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        Usuario usuario = new Usuario();

        usuario.setNome("juka");
        usuario.setEmail("juka@email.com");
        usuario.setSenha("juka@email.com");

        UsuarioController.incluir(usuario);
    }
}
