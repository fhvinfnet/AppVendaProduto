package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@Order(1)
public class UsuarioTest implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) {
        Usuario usuario = new Usuario();

        usuario.setNome("admin");
        usuario.setEmail("admin@admin.com");
        usuario.setSenha("123");

        usuarioService.incluir(usuario);

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "usuarios.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {

                    String[] campos = linha.split(";");

                    usuario = new Usuario();

                    usuario.setNome(campos[0]);
                    usuario.setEmail(campos[1]);
                    usuario.setSenha(campos[2]);

                    usuarioService.incluir(usuario);
                }

                leitura.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("[ERRO] - arquivo nao existe");
            } catch (IOException e) {
                System.out.println("[ERRO] - problemna no fechamento do arquivo");
            }
        } finally {
            System.out.println("terminou");
        }

    }
}
