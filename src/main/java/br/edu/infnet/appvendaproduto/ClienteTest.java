package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.exceptions.CpfInvalidoException;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.service.ClienteService;
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
@Order(2)
public class ClienteTest implements ApplicationRunner {

    @Autowired
    ClienteService clienteService;

    @Override
    public void run(ApplicationArguments args) {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("admin");
        usuario.setEmail("admin@admin.com");
        usuario.setSenha("123");

        System.out.println("###### Clientes");

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "cliente.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {

                    try {
                        String[] campos = linha.split(";");

                        Cliente cliente1 = new Cliente(campos[0], campos[1], campos[2]);

                        cliente1.setUsuario(usuario);

                        clienteService.incluir(cliente1);

                    } catch (CpfInvalidoException exception) {
                        System.out.println("[ERROR] - VENDA " + exception.getMessage());
                    }
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
