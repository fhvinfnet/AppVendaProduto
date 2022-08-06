package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.Venda;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VendaTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("#venda");

        Venda v1 = new Venda();
        v1.setDescricao("Venda 1");
        v1.setData(LocalDateTime.now());
        v1.setWeb(false);
        System.out.println(v1);

        Venda v2 = new Venda();
        v2.setDescricao("Venda 2");
        v2.setData(LocalDateTime.now());
        v2.setWeb(true);
        System.out.println(v2);

        Venda v3 = new Venda();
        v3.setDescricao("Venda 3");
        v3.setData(LocalDateTime.now());
        v3.setWeb(false);
        System.out.println(v3);
    }
}
