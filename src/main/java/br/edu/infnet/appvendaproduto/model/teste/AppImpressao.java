package br.edu.infnet.appvendaproduto.model.teste;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppImpressao {

    public static void relatorio(IPrinter printer, String mensagem) {
        System.out.println(mensagem);
        printer.impressao();
    }

    public static void main(String args[]) {
        String dir = "/Users/fernandovieira/dev/venda/";
        String arq = "venda.txt";

        try {
            try {
                FileReader fileReader = new FileReader(dir + arq);
                BufferedReader leitura = new BufferedReader(fileReader);

                String linha;

                while ((linha = leitura.readLine()) != null) {
                    System.out.println(linha);
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
