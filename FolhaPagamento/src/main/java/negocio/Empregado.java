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
public abstract class Empregado {
    
    private String nome;
    private String numPis;

    public Empregado(String nome, String numPis) {
        this.nome = nome;
        this.numPis = numPis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumPis() {
        return numPis;
    }

    public void setNumPis(String numPis) {
        this.numPis = numPis;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome()
                + "\nNr. PIS: " + this.getNumPis();
    }
    
    public abstract double ganhos();
    
    public abstract String linhatxt();
    
}
