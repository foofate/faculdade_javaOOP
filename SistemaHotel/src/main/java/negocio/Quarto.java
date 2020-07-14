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
public abstract class Quarto {
    
    private int numero;
    private boolean fumante;
    private Situacao situacao;

    public Quarto(int numero, boolean fumante) {
        this.numero = numero;
        this.fumante = fumante;
        this.situacao = Situacao.LIVRE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    public void ocupaQuarto() {
        this.setSituacao(Situacao.OCUPADO);
    }
    
    public void desocupaQuarto() {
        this.setSituacao(Situacao.AGUARDANDO_LIMPEZA);
    }
    
    public void limpaQuarto() {
        this.setSituacao(Situacao.LIVRE);
    }
    
    public void desativaQuarto() {
        this.setSituacao(Situacao.DESATIVADO);
    }
    
    public void reativaQuarto() {
        this.setSituacao(Situacao.LIVRE);
    }
    
    public String lineToPersist() {
        return this.getClass().getSimpleName() + ";"
                + this.getNumero() + ";"
                + this.isFumante() + ";"
                + this.getSituacao() + ";";
    }

    @Override
    public String toString() {
        String fumantes = (this.isFumante()) ? "sim" : "não";
        return "-----------------------"
                + "\nQuarto nº " + this.getNumero() + ":"
                + "\nPara fumantes: " + fumantes
                + "\nSituação: " + this.getSituacao();
    }
    
    /**
     * Método abstrato para cálculo de estadia que  
     * deverá ser implementado por cada classe que irá herdar esta.
     * @param numDias número de dias alugados.
     * @return Valor da estadia de acordo com cada tipo de quarto.
     */
    public abstract double calcularEstadia(int numDias);
}
