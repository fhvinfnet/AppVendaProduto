package br.edu.infnet.appvendaproduto.model.domain.app;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;

public class Classe implements IPrinter {

    private String nome;
    private List<Atributo> atributos = new ArrayList<>();

    @Override
    public void impressao() {
        System.out.println("- - " + nome);
        atributos.stream().forEach(Atributo::impressao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }
}
