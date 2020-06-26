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
public class ComissionadoComBase extends Comissionado {
    
    private double salarioBase;

    public ComissionadoComBase(String nome, String numPis, double percentComissao, double vendaBruta, double salarioBase) {
        super(nome, numPis, percentComissao, vendaBruta);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Funcionário Comissionado Com Salário Base\n"
                + super.toString()
                + "\nSalário Base: " + this.getSalarioBase();
    }

    @Override
    public double ganhos() {
        return this.getSalarioBase() + super.ganhos();
    }

    @Override
    public String linhatxt() {
        return "comissionadobase;" + super.getNome() + ";"
                + super.getNumPis() + ";"
                + this.getPercentComissao() + ";"
                + this.getVendaBruta() + ";"
                + this.getSalarioBase();
    }
    
    
    
    
    
}
