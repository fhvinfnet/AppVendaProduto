package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

public class Cliente implements IPrinter {

    private String nome;
    private String cpf;
    private String email;

    public Cliente(String cpf, String email, String nome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + email;
    }

    @Override
    public void impressao() {
        System.out.println("#cliente");
        System.out.println(this);
    }
}
