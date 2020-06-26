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
public class Mensalista extends Empregado {

    private double salarioMensal;

    public Mensalista(String nome, String numPis, double salarioMensal) {
        super(nome, numPis);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    @Override
    public String toString() {
        return "Funcionário Mensalista \n"
                + super.toString()
                + "\nSalário Mensal: " + this.getSalarioMensal();
    }

    @Override
    public double ganhos() {
        return this.getSalarioMensal();
    }

    @Override
    public String linhatxt() {
        return "mensalista;" + super.getNome() + ";"
                + super.getNumPis() + ";"
                + this.getSalarioMensal();
    }
    
    
}
