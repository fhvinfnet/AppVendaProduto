package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.controller.CelularController;
import br.edu.infnet.appvendaproduto.controller.ImpressoraController;
import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;
import br.edu.infnet.appvendaproduto.exceptions.SistemaDeImpressaoInvalido;
import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static br.edu.infnet.appvendaproduto.controller.ImpressoraController.incluir;

@Component
public class ImpressoraTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("###### Impressora");

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "impressora.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {

                    try {
                        String[] campos = linha.split(";");

                        Impressora impressora = new Impressora();

                        impressora.setCodigo(Integer.valueOf(campos[0]));
                        impressora.setNome(campos[1]);
                        impressora.setValor(Float.valueOf(campos[2]));
                        impressora.setPeso(Float.valueOf(campos[3]));
                        impressora.setSistemaDeImpressao(campos[4]);
                        impressora.setWifi(Boolean.valueOf(campos[5]));

                        System.out.println("calculo da venda: " + impressora.calcularVenda());

                        ImpressoraController.incluir(impressora);

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
