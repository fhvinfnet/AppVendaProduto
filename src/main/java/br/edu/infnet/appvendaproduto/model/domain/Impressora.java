package br.edu.infnet.appvendaproduto.model.domain;

public class Impressora extends Produto {
    public boolean wifi;
    public String sistemaDeImpressao;
    public float peso;

    @Override
    public String toString() {
        return super.toString() + ";" + wifi + ";" + sistemaDeImpressao + ";" + peso;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public String getSistemaDeImpressao() {
        return sistemaDeImpressao;
    }

    public void setSistemaDeImpressao(String sistemaDeImpressao) {
        this.sistemaDeImpressao = sistemaDeImpressao;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
