package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.controller.CelularController;
import br.edu.infnet.appvendaproduto.exceptions.CpfInvalidoException;
import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;
import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.CelularService;
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
@Order(3)
public class CelularTest implements ApplicationRunner {

    @Autowired
    CelularService celularService;

    @Override
    public void run(ApplicationArguments args) {

        Usuario usuario = new Usuario();
        usuario.setId(1);

        System.out.println("###### Celular");

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

                        if ("C".equalsIgnoreCase(campos[0])) {
                            Celular celular = new Celular();

                            celular.setCodigo(Integer.valueOf(campos[1]));
                            celular.setNome(campos[2]);
                            celular.setValor(Float.valueOf(campos[3]));
                            celular.setCameraFrontal(Boolean.valueOf(campos[4]));
                            celular.setDimensao(campos[5]);
                            celular.setMemoria(Float.valueOf(campos[6]));
                            celular.setUsuario(usuario);

                            System.out.println("calculo da venda: " + celular.calcularVenda());

                            celularService.incluir(celular);
                        }
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
