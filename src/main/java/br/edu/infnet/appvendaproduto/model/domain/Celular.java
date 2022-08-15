package br.edu.infnet.appvendaproduto.model.domain;

public class Celular extends Produto {
    private boolean cameraFrontal;
    private String dimensao;
    private float memoria;

    @Override
    public float calcularVenda() {
        float valorCameraFrontal = cameraFrontal ? 15 : 10;

        return getValor() + valorCameraFrontal;
    }

    @Override
    public void impressao() {
        System.out.println("#celular");
        System.out.println(this);
    }

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
        return  cameraFrontal + ";" + dimensao + ";" + memoria + super.toString();
    }
}
