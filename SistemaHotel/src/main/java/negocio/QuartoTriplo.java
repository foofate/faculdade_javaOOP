/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Gustavo Martini
 */
public class QuartoTriplo extends Quarto {
     
   private double valor;

    public QuartoTriplo(double valor, int numero, boolean fumante) {
        super(numero, fumante);
        this.valor = valor;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String lineToPersist() {
        return super.lineToPersist() + getValor();
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\nValor: " + this.getValor()
                + "\n";
    }
    
    @Override
    public double calcularEstadia(int numDias) {
        return numDias * valor;
    }
}
