package br.edu.infnet.appvendaproduto.model.domain;

public abstract class Produto {

    private String nome;
    private float valor;
    private int codigo;

    public float calcularVenda() {
        return valor * 2;
    }

    public abstract void impressao();

    @Override
    public String toString() {
        return nome + ";" + valor + ";" + codigo + ";" + calcularVenda();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
