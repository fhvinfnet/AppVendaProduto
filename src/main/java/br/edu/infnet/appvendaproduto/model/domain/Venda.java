package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda implements IPrinter {

    private String descricao;
    private LocalDateTime data;
    private boolean web;
    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + web + ";" + cliente + ";" + produtos.size();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void impressao() {
        System.out.println("#venda");
        System.out.println(this);
    }
}
