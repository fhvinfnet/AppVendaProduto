package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.exceptions.ClienteNuloException;
import br.edu.infnet.appvendaproduto.exceptions.CpfInvalidoException;
import br.edu.infnet.appvendaproduto.exceptions.VendaSemProdutoException;
import br.edu.infnet.appvendaproduto.model.domain.*;
import br.edu.infnet.appvendaproduto.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

@Component
@Order(1)
public class VendaTest implements ApplicationRunner {

    @Autowired
    private VendaService vendaService;

    private Venda vendaCorrente;

    @Override
    public void run(ApplicationArguments args) {

        System.out.println("###### Venda");

        try {
            try {
                String dir = "/Users/fernandovieira/dev/venda/";
                String arq = "venda.txt";

                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {

                    String[] campos = linha.split(";");

                    switch (campos[0].toUpperCase()) {
                        case "V":
                            try {
                                if (vendaCorrente != null && vendaCorrente.getProdutos().size() > 0) {
                                    vendaService.incluir(vendaCorrente);
                                }

                                Cliente cliente = new Cliente(campos[3], campos[4], campos[5]);

                                Venda venda = new Venda(cliente, new HashSet<>());

                                venda.setDescricao(campos[1]);
                                venda.setWeb(Boolean.parseBoolean(campos[2]));

                                this.vendaCorrente = venda;
                            } catch (CpfInvalidoException | ClienteNuloException | VendaSemProdutoException exception) {
                                System.out.println("[ERROR] - VENDA " + exception.getMessage());
                            }
                            break;

                        case "C":
                            Celular celular = new Celular();

                            celular.setCodigo(Integer.parseInt(campos[1]));
                            celular.setNome(campos[2]);
                            celular.setValor(Float.parseFloat(campos[3]));
                            celular.setCameraFrontal(Boolean.parseBoolean(campos[4]));
                            celular.setDimensao(campos[5]);
                            celular.setMemoria(Float.parseFloat(campos[6]));
                            vendaCorrente.getProdutos().add(celular);
                            break;

                        case "N":
                            Notebook notebook = new Notebook();
                            notebook.setCodigo(Integer.parseInt(campos[1]));
                            notebook.setNome(campos[2]);
                            notebook.setValor(Float.parseFloat(campos[3]));
                            notebook.setConfiguracao(campos[4]);
                            notebook.setPolegadas(Float.parseFloat(campos[5]));
                            notebook.setSsd(Boolean.parseBoolean(campos[6]));
                            vendaCorrente.getProdutos().add(notebook);
                            this.vendaCorrente = vendaCorrente;
                            break;

                        case "I":
                            Impressora impressora = new Impressora();
                            impressora.setCodigo(Integer.parseInt(campos[1]));
                            impressora.setNome(campos[2]);
                            impressora.setValor(Float.parseFloat(campos[3]));
                            impressora.setPeso(Float.parseFloat(campos[4]));
                            impressora.setSistemaDeImpressao(campos[5]);
                            impressora.setWifi(Boolean.parseBoolean(campos[6]));
                            vendaCorrente.getProdutos().add(impressora);
                            break;

                        default:
                            break;
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
