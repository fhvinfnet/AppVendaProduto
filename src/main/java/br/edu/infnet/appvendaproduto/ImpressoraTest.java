package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static br.edu.infnet.appvendaproduto.controller.ImpressoraController.incluir;

@Component
public class ImpressoraTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("###### Impressoa");

        Impressora i1 = new Impressora();
        i1.setCodigo(1);
        i1.setNome("meu Impressora 1");
        i1.setValor(100F);
        i1.setPeso(5F);
        i1.setSistemaDeImpressao("tonner");
        i1.setWifi(Boolean.FALSE);

        Impressora i2 = new Impressora();
        i2.setCodigo(2);
        i2.setNome("meu Impressora 2");
        i2.setValor(150F);
        i2.setPeso(6F);
        i2.setSistemaDeImpressao("tinta");
        i2.setWifi(Boolean.TRUE);

        Impressora i3 = new Impressora();
        i3.setCodigo(3);
        i3.setNome("meu Impressora 3");
        i3.setValor(200F);
        i3.setPeso(4F);
        i3.setSistemaDeImpressao("tinta");
        i3.setWifi(Boolean.TRUE);

        incluir(i1);
        incluir(i2);
        incluir(i3);
    }
}
