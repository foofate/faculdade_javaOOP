package negocio;

import apresentacao.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class ContaBancaria {

    private Integer numero;
    private Correntista correntista;
    private double saldo;
    private double limiteCredito;
    private Data dataUltimaMov;
    private boolean contaBloqueada;
    private ArrayList<Movimento> lancamento = new ArrayList<>();
    

    public ContaBancaria(Correntista correntista, double limiteCredito) {
        this.correntista = correntista;
        this.limiteCredito = limiteCredito;
        this.saldo = 0;
        this.contaBloqueada = false;   
        this.dataUltimaMov = new Data();
        
        lancamento.add(new Movimento('I', 0, "Conta criada", saldo));
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Data getDataUltimaMov() {
        return dataUltimaMov;
    }

    public void setDataUltimaMov(Data dataUltimaMov) {
        this.dataUltimaMov = dataUltimaMov;
    }

    public boolean isContaBloqueada() {
        return contaBloqueada;
    }

    private void setContaBloqueada(boolean contaBloqueada) {
        this.contaBloqueada = contaBloqueada;
    }
    
    public double disponivel() {
        return this.getSaldo() + this.getLimiteCredito();
    }

    public void deposito(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        this.dataUltimaMov.setDataComoHoje();
        
        System.out.println("Depósito no valor de R$" + valor + " confirmado em " + dataUltimaMov.formatarData(1)+ ".");
    }
    
    /*
    retorna se o saque foi realizado
    */
    public boolean saque(double valor) {
        boolean saqueOk = false;
        double saldoConta = this.getSaldo() + this.getLimiteCredito();
        //tenho saldo suficiente? tenho limite de crédito?
        if (saldoConta >=valor) {
            this.setSaldo(this.getSaldo() - valor);
            this.dataUltimaMov.setDataComoHoje();
            saqueOk = true;
            System.out.println(String.format("Saque confirmado no valor de R$%.2f.", valor));
        }
        if (!saqueOk) {
            System.out.println(String.format("Saldo indisponível! O máximo que você pode sacar é R$%.2f.", (getLimiteCredito() + getSaldo())));
        }
        return saqueOk;
    }
    
    public boolean pgtoBoleto(double valor) {
        boolean pgtoOk = this.saque(valor);
        return pgtoOk;
    }
    
    public boolean compensCheque(double valor) {
        boolean compensOk = this.saque(valor);
        if(!compensOk) {
            this.setContaBloqueada(true); //cheque sem fundo bloqueia conta
            System.out.println("Conta bloqueada!!!");
        }
        return compensOk;
    }
    
    public void desbloquearConta() {
        this.setContaBloqueada(false);
        System.out.println("Conta desbloqueada");
    }
    
    public boolean transferencia(ContaBancaria outraConta, double valor) {
        boolean transfOk = false;
        if (this.saque(valor)) {
            outraConta.deposito(valor);
            transfOk = true;
        }
        
        
        return transfOk;
    }

    @Override
    public String toString() {
        return "Conta Bancaria numero: " + numero
                + "\nCorrentista:" + correntista
                + "\nSaldo: " + saldo
                + "\nLimite de Crédito: " + limiteCredito
                + "\nData da última movimentação: " + dataUltimaMov.formatarData(1)
                + "\nConta bloqueada: " + contaBloqueada;
    }
    
    
}

    /*
    desbloquear conta
    fornecer cheques
    ...
    */
