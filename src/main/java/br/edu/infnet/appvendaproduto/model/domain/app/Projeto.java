package br.edu.infnet.appvendaproduto.model.domain.app;

import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import java.util.ArrayList;
import java.util.List;

public class Projeto implements IPrinter {

    private String nome;
    private String descricao;
    private List<Classe> classes = new ArrayList<>();

    @Override
    public void impressao() {
        System.out.println("- " + nome + "|" + descricao);

        classes.stream().forEach(Classe::impressao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
}
