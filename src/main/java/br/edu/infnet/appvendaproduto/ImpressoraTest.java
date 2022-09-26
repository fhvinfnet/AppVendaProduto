package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.controller.CelularController;
import br.edu.infnet.appvendaproduto.controller.ImpressoraController;
import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;
import br.edu.infnet.appvendaproduto.exceptions.SistemaDeImpressaoInvalido;
import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.ImpressoraService;
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
@Order(4)
public class ImpressoraTest implements ApplicationRunner {

    @Autowired
    ImpressoraService impressoraService;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("###### Impressora");

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "produto.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {

                    try {
                        String[] campos = linha.split(";");

                        if ("I".equalsIgnoreCase(campos[0])) {
                            Impressora impressora = new Impressora();

                            impressora.setCodigo(Integer.valueOf(campos[1]));
                            impressora.setNome(campos[2]);
                            impressora.setValor(Float.valueOf(campos[3]));
                            impressora.setPeso(Float.valueOf(campos[4]));
                            impressora.setSistemaDeImpressao(campos[5]);
                            impressora.setWifi(Boolean.valueOf(campos[6]));

                            System.out.println("calculo da venda: " + impressora.calcularVenda());

                            impressoraService.incluir(impressora);
                        }
                    } catch (SistemaDeImpressaoInvalido e) {
                        System.out.println("[ERROR - IMPRESSORA] " + e.getMessage());
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
