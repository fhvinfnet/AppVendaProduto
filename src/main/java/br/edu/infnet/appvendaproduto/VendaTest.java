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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        i1.setNome("minha Impressora 3");
        i1.setValor(100F);
        i1.setPeso(5F);
        i1.setSistemaDeImpressao("tonner");
        i1.setWifi(Boolean.FALSE);

        Notebook n1 = new Notebook();
        n1.setCodigo(4);
        n1.setNome("meu Notebook 4");
        n1.setValor(100F);
        n1.setConfiguracao("coinfiguracao do meu notebook 4");
        n1.setPolegadas(13F);
        n1.setSsd(Boolean.FALSE);

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "venda.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {

                    try {
                        String[] campos = linha.split(";");

                        Cliente cliente1 = new Cliente(campos[2], campos[3], campos[4]);

                        Venda v1 = new Venda(cliente1, new HashSet<>(Set.of(c1, c2, i1)));
                        v1.setDescricao(campos[0]);
                        v1.setWeb(Boolean.valueOf(campos[1]));

                        incluir(v1);
                    } catch (CpfInvalidoException | ClienteNuloException | VendaSemProdutoException exception) {
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
