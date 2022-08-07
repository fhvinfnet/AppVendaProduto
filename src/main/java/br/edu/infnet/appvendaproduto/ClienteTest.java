package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("clientes");

        Cliente c1 = new Cliente("12345678901", "joao", "joao@email.com");
        System.out.println(c1);

        Cliente c2 = new Cliente("12345678902", "maria", "joao@email.com");
        System.out.println(c2);

        Cliente c3 = new Cliente("12345678903", "jose", "joao@email.com");
        System.out.println(c3);
    }
}
