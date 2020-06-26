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
public class Comissionado extends Empregado {
    
    private double percentComissao;
    private double vendaBruta;

    public Comissionado(String nome, String numPis, double percentComissao, double vendaBruta) {
        super(nome, numPis);
        this.percentComissao = percentComissao;
        this.vendaBruta = vendaBruta;
    }

    public double getPercentComissao() {
        return percentComissao;
    }

    public void setPercentComissao(double percentComissao) {
        if (percentComissao > 0.0 && percentComissao <= 100.0) {
            this.percentComissao = percentComissao;
        } else {
            this.percentComissao = 0.0;
        }
    }

    public double getVendaBruta() {
        return vendaBruta;
    }

    public void setVendaBruta(double vendaBruta) {
        this.vendaBruta = (vendaBruta < 0) ? 0.0 : vendaBruta;
    }

    @Override
    public String toString() {
        return "Funcionário Comissionado\n"
                + super.toString()
                + "\nPercentual comissão: " + this.getPercentComissao()
                + "\nValor Venda Bruta: " + this.getVendaBruta();
    }

    @Override
    public double ganhos() {
        return this.getVendaBruta() * (this.getPercentComissao() / 100);
    }

    @Override
    public String linhatxt() {
        return "comissionado;" + super.getNome() + ";"
                + super.getNumPis() + ";"
                + this.getPercentComissao() + ";"
                + this.getVendaBruta();
    }
    
    
    
}
