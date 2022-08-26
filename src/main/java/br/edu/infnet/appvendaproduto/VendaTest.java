package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.exceptions.ClienteNuloException;
import br.edu.infnet.appvendaproduto.exceptions.CpfInvalidoException;
import br.edu.infnet.appvendaproduto.exceptions.VendaSemProdutoException;
import br.edu.infnet.appvendaproduto.model.domain.*;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static br.edu.infnet.appvendaproduto.controller.VendaController.incluir;

@Component
@Order(1)
public class VendaTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("###### Venda");

        Celular c1 = new Celular();
        c1.setCodigo(1);
        c1.setNome("meu celular 1");
        c1.setValor(100F);
        c1.setCameraFrontal(Boolean.FALSE);
        c1.setDimensao("4 x 3");
        c1.setMemoria(2.3F);

        Celular c2 = new Celular();
        c2.setCodigo(2);
        c2.setNome("meu celular 2");
        c2.setValor(150F);
        c2.setCameraFrontal(Boolean.TRUE);
        c2.setDimensao("4 x 3");
        c2.setMemoria(8F);

        Impressora i1 = new Impressora();
        i1.setCodigo(3);
        i1.setNome("minha Impressora 1");
        i1.setValor(100F);
        i1.setPeso(5F);
        i1.setSistemaDeImpressao("tonner");
        i1.setWifi(Boolean.FALSE);

        Notebook n1 = new Notebook();
        n1.setCodigo(4);
        n1.setNome("meu Notebook 1");
        n1.setValor(100F);
        n1.setConfiguracao("coinfiguracao do meu notebook 1");
        n1.setPolegadas(13F);
        n1.setSsd(Boolean.FALSE);

        try {
            Cliente cliente1 = new Cliente("12345678901", "joao", "joao@email.com");

            Venda v1 = new Venda(cliente1, new HashSet<>(Set.of(c1, c2, i1)));
            v1.setDescricao("Venda 1");
            v1.setWeb(false);

            incluir(v1);
        } catch (CpfInvalidoException | ClienteNuloException | VendaSemProdutoException exception) {
            System.out.println("[ERROR] - VENDA " + exception.getMessage());
        }

        try {
            Cliente cliente2 = new Cliente("12345678902", "maria", "maria@email.com");

            Venda v2 = new Venda(cliente2, new HashSet<>(Set.of(n1)));
            v2.setDescricao("Venda 2");
            v2.setWeb(true);

            incluir(v2);
        } catch (CpfInvalidoException | ClienteNuloException | VendaSemProdutoException exception) {
            System.out.println("[ERROR] - VENDA " + exception.getMessage());
        }

        try {
            Cliente cliente3 = new Cliente("12345678903", "jose", "jose@email.com");

            Venda v3 = new Venda(cliente3, new HashSet<>(Set.of(n1, c1)));
            v3.setDescricao("Venda 3");
            v3.setWeb(false);

            incluir(v3);
        } catch (CpfInvalidoException | ClienteNuloException | VendaSemProdutoException exception) {
            System.out.println("[ERROR] - VENDA " + exception.getMessage());
        }

        try {
            Cliente cliente4 = new Cliente("12345678904", "joana", "joana@email.com");

            Venda v3 = new Venda(null, new HashSet<>(Set.of(n1, c1)));
            v3.setDescricao("Venda 4");
            v3.setWeb(false);

            incluir(v3);
        } catch (CpfInvalidoException | ClienteNuloException | VendaSemProdutoException exception) {
            System.out.println("[ERROR] - VENDA " + exception.getMessage());
        }

        try {
            Cliente cliente5 = new Cliente("12345678905", "elena", "elena@email.com");

            Venda v3 = new Venda(cliente5, null);
            v3.setDescricao("Venda 5");
            v3.setWeb(false);

            incluir(v3);
        } catch (CpfInvalidoException | ClienteNuloException | VendaSemProdutoException exception) {
            System.out.println("[ERROR] - VENDA " + exception.getMessage());
        }
    }
}
