package br.edu.infnet.appvendaproduto.model.domain;

public class Impressora extends Produto {
    public boolean wifi;
    public String sistemaDeImpressao;
    public float peso;

    @Override
    public String toString() {
        return wifi + ";" + sistemaDeImpressao + ";" + peso;
    }
}
