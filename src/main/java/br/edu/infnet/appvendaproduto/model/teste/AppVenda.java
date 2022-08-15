package br.edu.infnet.appvendaproduto.model.teste;

import br.edu.infnet.appvendaproduto.model.domain.Produto;

public class AppVenda {

    private Produto produto;
    private String mensagem;

    public AppVenda(Produto produto, String mensagem) {
        this.produto = produto;
        this.mensagem = mensagem;
    }

    public void relatorio() {
        System.out.println(mensagem);
        produto.impressao();
    }

}
