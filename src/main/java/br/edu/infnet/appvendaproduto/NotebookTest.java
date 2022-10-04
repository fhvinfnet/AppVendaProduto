package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;
import br.edu.infnet.appvendaproduto.exceptions.PolegadaNotebookInvalidaException;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.service.NotebookService;
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
public class NotebookTest implements ApplicationRunner {

    @Autowired
    private NotebookService notebookService;

    @Override
    public void run(ApplicationArguments args) {
        Usuario usuario = new Usuario();
        usuario.setId(1);

        System.out.println("###### Notebook");

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

                        if ("N".equalsIgnoreCase(campos[0])) {
                            Notebook n1 = new Notebook();
                            n1.setUsuario(usuario);
                            n1.setCodigo(Integer.valueOf(campos[1]));
                            n1.setNome(campos[2]);
                            n1.setValor(Float.valueOf(campos[3]));
                            n1.setConfiguracao(campos[4]);
                            n1.setPolegadas(Float.valueOf(campos[5]));
                            n1.setSsd(Boolean.valueOf(campos[6]));

                            System.out.println("calculo da venda: " + n1.calcularVenda());

                            notebookService.incluir(n1);
                        }

                    } catch (PolegadaNotebookInvalidaException e) {
                        System.out.println("[ERROR - NOTEBOOK] " + e.getMessage());
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
