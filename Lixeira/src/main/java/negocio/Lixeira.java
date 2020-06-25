/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author gustavo
 */
public class Lixeira {
    
    private double altura;
    private double raio;
    private double volumeAtual;
    private boolean cheia;
    private boolean vazia;

    public Lixeira(double altura, double raio) {
        this.altura = altura;
        this.raio = raio;
        this.volumeAtual = 0;
        this.cheia = false;
        this.vazia = true;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getVolumeAtual() {
        return volumeAtual;
    }

    public void setVolumeAtual(double volumeAtual) {
        this.volumeAtual = volumeAtual;
    }
    
    public boolean isCheia() {
        return cheia;
    }

    public void setCheia(boolean cheia) {
        this.cheia = cheia;
    }

    public boolean isVazia() {
        return vazia;
    }

    public void setVazia(boolean vazia) {
        this.vazia = vazia;
    }
    
    public double area() {
        double area = Math.PI * Math.pow(raio, 2);
        return Math.round(area);
    }
    
    public double volumeMaximo() {
        double volume = area() * getAltura();
        return Math.round(volume);
    }
    
    public void encher() {
        if (getVolumeAtual() + 100 < volumeMaximo()) {
            setVolumeAtual(getVolumeAtual() + 100);
            setVazia(false);
        } else {
            setCheia(true);
        }
    }
    
    public void esvaziar() {
        setVazia(true);
        setVolumeAtual(0);
    }
    
}
