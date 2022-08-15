package br.edu.infnet.appvendaproduto.model.domain;

public class Impressora extends Produto {
    private boolean wifi;
    private String sistemaDeImpressao;
    private float peso;

    @Override
    public float calcularVenda() {
        float valorWifi = this.wifi ? 10 : 5;
        return super.calcularVenda() + valorWifi;
    }

    @Override
    public String toString() {
        return wifi + ";" + sistemaDeImpressao + ";" + peso + ";" + super.toString();
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
