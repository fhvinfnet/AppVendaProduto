package br.edu.infnet.appvendaproduto.model.domain;

public class Notebook extends Produto {
    private boolean ssd;
    private String configuracao;
    private float polegadas;

    @Override
    public float calcularVenda() {
        return getValor() * 2;
    }

    @Override
    public String toString() {
        return ssd + ";" + configuracao + ";" + polegadas + ";" + super.toString();
    }

    @Override
    public void impressao() {
        System.out.println("#notebook");
        System.out.println(this);
    }

    public boolean isSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    public String getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }

    public float getPolegadas() {
        return polegadas;
    }

    public void setPolegadas(float polegadas) {
        this.polegadas = polegadas;
    }
}
