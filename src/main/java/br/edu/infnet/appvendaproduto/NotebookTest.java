package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.exceptions.PolegadaNotebookInvalidaException;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static br.edu.infnet.appvendaproduto.controller.NotebookController.incluir;

@Component
public class NotebookTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("###### Notebook");

        try {
            Notebook n1 = new Notebook();
            n1.setCodigo(1);
            n1.setNome("meu Notebook 1");
            n1.setValor(100F);
            n1.setConfiguracao("coinfiguracao do meu notebook 1");
            n1.setPolegadas(13F);
            n1.setSsd(Boolean.FALSE);
            System.out.println("calculo da venda: " + n1.calcularVenda());
            incluir(n1);
        } catch (PolegadaNotebookInvalidaException e) {
            System.out.println("[ERROR - NOTEBOOK] " + e.getMessage());
        }

        try {
            Notebook n2 = new Notebook();
            n2.setCodigo(2);
            n2.setNome("meu Notebook 2");
            n2.setValor(150F);
            n2.setConfiguracao("configuracao do meu notebook 2");
            n2.setPolegadas(15F);
            n2.setSsd(Boolean.TRUE);
            System.out.println("calxculo da venda: " + n2.calcularVenda());
            incluir(n2);
        } catch (PolegadaNotebookInvalidaException e) {
            System.out.println("[ERROR - NOTEBOOK] " + e.getMessage());
        }

        try {
            Notebook n3 = new Notebook();
            n3.setCodigo(3);
            n3.setNome("meu Notebook 3");
            n3.setValor(200F);
            n3.setConfiguracao("configuracao do meu notebook 3");
            n3.setPolegadas(14F);
            n3.setSsd(Boolean.TRUE);
            System.out.println("calculo da venda: " + n3.calcularVenda());
            incluir(n3);
        } catch (PolegadaNotebookInvalidaException e) {
            System.out.println("[ERROR - NOTEBOOK] " + e.getMessage());
        }

        try {
            Notebook n4 = new Notebook();
            n4.setCodigo(3);
            n4.setNome("meu Notebook 3");
            n4.setValor(200F);
            n4.setConfiguracao("configuracao do meu notebook 3");
            n4.setPolegadas(5F);
            n4.setSsd(Boolean.TRUE);
            System.out.println("calculo da venda: " + n4.calcularVenda());
            incluir(n4);
        } catch (PolegadaNotebookInvalidaException e) {
            System.out.println("[ERROR - NOTEBOOK] " + e.getMessage());
        }
    }
}
