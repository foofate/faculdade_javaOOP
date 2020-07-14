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
public class Despesa {
    
    private double valor;
    private Categoria categoria;
    private String descricao;

    public Despesa(double valor, Categoria categoria, String descricao) {
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Valor: " + this.getValor()
                + "Categoria: " + this.getCategoria()
                + "Descrição: " + this.getDescricao();
    }
    
    public String lineToPersist() {
        return this.getCategoria() + ";" + this.getValor() + ";" + this.getDescricao();
    }
    
    
}
