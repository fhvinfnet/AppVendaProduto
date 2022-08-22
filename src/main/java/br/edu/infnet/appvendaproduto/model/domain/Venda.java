package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Venda implements IPrinter {

    private Integer id;
    private String descricao;
    private LocalDateTime data;
    private boolean web;
    private Cliente cliente;
    private Set<Produto> produtos = new HashSet<>();

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + web + ";" + cliente + ";" + produtos.size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getData() {
        return data;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public void impressao() {
        System.out.println("#venda");
        System.out.println(this);
    }


}
