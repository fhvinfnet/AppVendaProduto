package br.edu.infnet.appvendaproduto.model.domain;

public class Celular extends Produto {
    private boolean cameraFrontal;
    private String dimensao;
    private float memoria;

    public boolean isCameraFrontal() {
        return cameraFrontal;
    }

    public void setCameraFrontal(boolean cameraFrontal) {
        this.cameraFrontal = cameraFrontal;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public float getMemoria() {
        return memoria;
    }

    public void setMemoria(float memoria) {
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + cameraFrontal + ";" + dimensao + ";" + memoria;
    }
}
