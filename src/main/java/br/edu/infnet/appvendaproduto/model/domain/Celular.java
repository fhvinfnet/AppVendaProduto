package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;

public class Celular extends Produto {
    private boolean cameraFrontal;
    private String dimensao;
    private float memoria;

    @Override
    public float calcularVenda() throws MemoriaDeCelularInvalidaException {
        float valorCameraFrontal = cameraFrontal ? 15 : 10;

        if (memoria < 8) {
            throw new MemoriaDeCelularInvalidaException("um celular nao pode ter menos que 8 de memoria");
        }

        float valorMemoria = memoria * 0.05f;

        return getValor() + valorCameraFrontal + valorMemoria;
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
