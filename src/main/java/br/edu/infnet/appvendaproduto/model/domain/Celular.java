package br.edu.infnet.appvendaproduto.model.domain;

public class Celular extends Produto {
    public boolean cameraFrontal;
    public String dimensao;
    public float memoria;

    @Override
    public String toString() {
        return cameraFrontal + ";" + dimensao + ";" + memoria;
    }
}
