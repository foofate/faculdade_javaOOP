package negocio;


import apresentacao.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class Movimento {
    
    private Data dataMovimento;
    private char operacao;
    private double valor;
    private String historico;
    private double saldoAposMov;

    public Movimento(char operacao, double valor, String historico, double saldoAposMov) {
        this.dataMovimento = new Data();
        this.operacao = operacao;
        this.valor = valor;
        this.historico = historico;
        this.saldoAposMov = saldoAposMov;
    }

    public Data getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Data dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public char getOperacao() {
        return operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public double getSaldoAposMov() {
        return saldoAposMov;
    }

    public void setSaldoAposMov(double saldoAposMov) {
        this.saldoAposMov = saldoAposMov;
    }

    @Override
    public String toString() {
        return dataMovimento + "..." + historico + "......" + valor + "" + operacao + "....." + "saldo" + saldoAposMov;
        //return "Movimento{" + "dataMovimento=" + dataMovimento + ", operacao=" + operacao + ", valor=" + valor + ", historico=" + historico + ", saldoAposMov=" + saldoAposMov + '}';
    }
    
    
    
    
}
