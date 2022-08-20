package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import java.time.LocalDateTime;

public class Venda implements IPrinter {

    private String descricao;
    private LocalDateTime data;
    private boolean web;
    private Cliente cliente;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + web + ";" + cliente;
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

    @Override
    public void impressao() {
        System.out.println("#venda");
        System.out.println(this);
    }
}
