package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.exceptions.SistemaDeImpressaoInvalido;

public class Impressora extends Produto {
    private boolean wifi;
    private String sistemaDeImpressao;
    private float peso;

    @Override
    public float calcularVenda() throws SistemaDeImpressaoInvalido {
        if (sistemaDeImpressao == null || sistemaDeImpressao.isBlank()) {
            throw new SistemaDeImpressaoInvalido("o sistema de impressao deve ser informado");
        }

        float valorWifi = this.wifi ? 10 : 5;

        return getValor() * 2 + valorWifi;
    }

    @Override
    public String toString() {
        return wifi + ";" + sistemaDeImpressao + ";" + peso + ";" + super.toString();
    }

    @Override
    public void impressao() {
        System.out.println("#impressora");
        System.out.println(this);
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
