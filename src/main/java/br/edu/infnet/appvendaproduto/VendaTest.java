package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.*;
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

        Cliente cliente1 = new Cliente("12345678901", "joao", "joao@email.com");
        Cliente cliente2 = new Cliente("12345678902", "maria", "maria@email.com");
        Cliente cliente3 = new Cliente("12345678903", "jose", "jose@email.com");

        Celular c1 = new Celular();
        c1.setCodigo(1);
        c1.setNome("meu celular 1");
        c1.setValor(100F);
        c1.setCameraFrontal(Boolean.FALSE);
        c1.setDimensao("4 x 3");
        c1.setMemoria(2.3F);

        Impressora i1 = new Impressora();
        i1.setCodigo(1);
        i1.setNome("meu Impressora 1");
        i1.setValor(100F);
        i1.setPeso(5F);
        i1.setSistemaDeImpressao("tonner");
        i1.setWifi(Boolean.FALSE);

        Notebook n1 = new Notebook();
        n1.setCodigo(1);
        n1.setNome("meu Notebook 1");
        n1.setValor(100F);
        n1.setConfiguracao("coinfiguracao do meu notebook 1");
        n1.setPolegadas(13F);
        n1.setSsd(Boolean.FALSE);

        Venda v1 = new Venda(cliente1);
        v1.setDescricao("Venda 1");
        v1.setWeb(false);
        v1.getProdutos().add(c1);
        v1.getProdutos().add(i1);
        AppImpressao.relatorio(v1, v1.getDescricao());

        Venda v2 = new Venda(cliente2);
        v2.setDescricao("Venda 2");
        v2.setWeb(true);
        v2.getProdutos().add(n1);
        AppImpressao.relatorio(v2, v2.getDescricao());

        Venda v3 = new Venda(cliente3);
        v3.setDescricao("Venda 3");
        v3.setWeb(false);
        v3.getProdutos().add(n1);
        v3.getProdutos().add(c1);
        AppImpressao.relatorio(v3, v3.getDescricao());
    }
}
