package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.exceptions.CpfInvalidoException;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static br.edu.infnet.appvendaproduto.controller.ClienteController.incluir;

@Component
public class ClienteTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("###### Clientes");

        try {
            Cliente c1 = null;
            c1 = new Cliente("12345678901", "joao", "joao@email.com");
            incluir(c1);
        } catch (CpfInvalidoException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            Cliente c2 = null;
            c2 = new Cliente("12345678902", "maria", "maria@email.com");
            incluir(c2);
        } catch (CpfInvalidoException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }

        try {
            Cliente c3 = null;
            c3 = new Cliente("12345678903", "jose", "jose@email.com");
            incluir(c3);
        } catch (CpfInvalidoException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }

        try {
            Cliente c4 = null;
            c4 = new Cliente(null, "pedro", "pedro@email.com");
            incluir(c4);
        } catch (CpfInvalidoException exception) {
            System.out.println("[ERROR] - CLIENTE " + exception.getMessage());
        }

        try {
            Cliente c5 = null;
            c5 = new Cliente(" ", "joana", "joana@email.com");
            incluir(c5);

        } catch (CpfInvalidoException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }
    }
}
