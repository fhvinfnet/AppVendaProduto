package br.edu.infnet.appvendaproduto.model.domain;

public class Notebook extends Produto {
    public boolean ssd;
    public String configuracao;
    public float polegadas;

    @Override
    public String toString() {
        return ssd + ";" + configuracao + ";" + polegadas;
    }
}
