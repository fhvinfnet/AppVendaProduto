package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.app.Atributo;
import br.edu.infnet.appvendaproduto.model.domain.app.Classe;
import br.edu.infnet.appvendaproduto.model.domain.app.Projeto;
import br.edu.infnet.appvendaproduto.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class AppTest implements ApplicationRunner {

    @Autowired
    AppService appService;

    @Override
    public void run(ApplicationArguments args) {

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "app.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                Projeto projeto = new Projeto();

                while ((linha = leitura.readLine()) != null) {

                    String[] campos = linha.split(";");

                    switch (campos[0].toUpperCase()) {
                        case "P": {
                            projeto.setNome(campos[1]);
                            projeto.setDescricao(campos[2]);
                            break;
                        }
                        case "C": {
                            Classe classe = new Classe();
                            classe.setNome(campos[1]);
                            projeto.getClasses().add(classe);
                            break;
                        }
                        case "A": {
                            Classe classe = projeto.getClasses().stream().reduce((f, s) -> s).get();
                            classe.getAtributos().add(new Atributo(campos[1], campos[2], campos[3]));
                            break;
                        }
                        default:
                            break;
                    }
                }

                appService.incluir(projeto);

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
