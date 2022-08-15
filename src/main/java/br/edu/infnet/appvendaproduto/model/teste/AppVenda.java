package br.edu.infnet.appvendaproduto.model.teste;

import br.edu.infnet.appvendaproduto.model.domain.Produto;

public class AppVenda {

    private String mensagem;

    public AppVenda(String mensagem) {
        this.mensagem = mensagem;
    }

    public void relatorio(Produto produto) {
        System.out.println(mensagem);
        produto.impressao();
    }

}
