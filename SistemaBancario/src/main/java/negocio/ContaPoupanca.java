
package negocio;

import apresentacao.Data;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Martini
 */
public class ContaPoupanca extends ContaBancaria {
    
    private int diaAniversario;
    private double reajustePercentual;

    static ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();
    
    public ContaPoupanca(double reajustePercentual, Correntista correntista, double limiteCredito) {
        super(correntista, limiteCredito);
        this.reajustePercentual = reajustePercentual;
    }
    
    public static ContaPoupanca getContaPoupanca(int i) {
        return contasPoupanca.get(i);
    }

    @Override
    public void deposito(double valor) {
        super.deposito(valor); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public double getReajustePercentual() {
        return reajustePercentual;
    }

    public void setReajustePercentual(double reajustePercentual) {
        this.reajustePercentual = reajustePercentual;
    }
    
    
   
    
    
}
