package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.exceptions.PolegadaNotebookInvalidaException;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TNotebook")
public class Notebook extends Produto {
    private boolean ssd;
    private String configuracao;
    private float polegadas;

    @Override
    public float calcularVenda() throws PolegadaNotebookInvalidaException {
        if (polegadas < 10) {
            throw new PolegadaNotebookInvalidaException("polegada de notebook nao pode ser menor que 10");
        }

        float valorPolegadas = polegadas > 13 ? 100 : 0;

        return getValor() + valorPolegadas;
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
