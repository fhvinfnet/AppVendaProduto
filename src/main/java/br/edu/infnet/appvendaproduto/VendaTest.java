package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Venda;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Order(1)
public class VendaTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("####venda");

        Cliente c1 = new Cliente("12345678901", "joao", "joao@email.com");
        Cliente c2 = new Cliente("12345678902", "maria", "joao@email.com");
        Cliente c3 = new Cliente("12345678903", "jose", "joao@email.com");

        Venda v1 = new Venda(c1);
        v1.setDescricao("Venda 1");
        v1.setData(LocalDateTime.now());
        v1.setWeb(false);
        AppImpressao.relatorio(v1, v1.getDescricao());

        Venda v2 = new Venda(c2);
        v2.setDescricao("Venda 2");
        v2.setData(LocalDateTime.now());
        v2.setWeb(true);
        AppImpressao.relatorio(v1, v1.getDescricao());

        Venda v3 = new Venda(c3);
        v3.setDescricao("Venda 3");
        v3.setData(LocalDateTime.now());
        v3.setWeb(false);
        AppImpressao.relatorio(v1, v1.getDescricao());
    }
}
