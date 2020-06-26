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
public class Horista extends Empregado {
    
    private double valorHora;
    private double horasTrabalhadas;

    public Horista(String nome, String numPis, double valorHora, double horasTrabalhadas) {
        super(nome, numPis);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public String toString() {
        return "Funcionário Horista\n"
                + super.toString()
                + "\nValor hora: " + this.getValorHora()
                + "\nHoras trabalhadas: " + this.getHorasTrabalhadas();
    }
    
    @Override
    public double ganhos() {
        if (this.getHorasTrabalhadas() > 180) {
            return 180 * this.getValorHora() + (this.getHorasTrabalhadas() - 180) * this.getValorHora() * 1.50;
        } else {
            return this.getHorasTrabalhadas() * this.getValorHora();
        }
    }

    @Override
    public String linhatxt() {
        return "horista;" + super.getNome() + ";"
                + super.getNumPis() + ";"
                + this.getValorHora() + ";"
                + this.getHorasTrabalhadas();
    }
    
    
    
}
