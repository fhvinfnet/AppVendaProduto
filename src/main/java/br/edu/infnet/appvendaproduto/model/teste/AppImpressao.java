package br.edu.infnet.appvendaproduto.model.teste;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

public class AppImpressao {

    public static void relatorio(IPrinter printer, String mensagem) {
        System.out.println(mensagem);
        printer.impressao();
    }

}
