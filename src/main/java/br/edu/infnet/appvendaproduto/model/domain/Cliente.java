package br.edu.infnet.appvendaproduto.model.domain;

public class Cliente {

    public String nome;
    public String cpf;
    public String email;

    public Cliente(String cpf, String email, String nome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + email;
    }
}
