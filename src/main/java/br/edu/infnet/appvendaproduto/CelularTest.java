package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.controller.CelularController;
import br.edu.infnet.appvendaproduto.exceptions.CpfInvalidoException;
import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;
import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static br.edu.infnet.appvendaproduto.controller.ClienteController.incluir;

@Component
public class CelularTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("###### Celular");

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "celular.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {

                    try {
                        String[] campos = linha.split(";");

                        Celular celular = new Celular();

                        celular.setCodigo(Integer. valueOf(campos[0]));
                        celular.setNome(campos[1]);
                        celular.setValor(Float.valueOf(campos[2]));
                        celular.setCameraFrontal(Boolean.valueOf(campos[3]));
                        celular.setDimensao(campos[4]);
                        celular.setMemoria(Float.valueOf(campos[5]));

                        System.out.println("calculo da venda: " + celular.calcularVenda());

                        CelularController.incluir(celular);

                    } catch (MemoriaDeCelularInvalidaException e) {
                        System.out.println("[ERROR - CELULAR] " + e.getMessage());
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
