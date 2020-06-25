package negocio;

import persistencia.EstacionamentoDAO;

/**
 *
 * @author Gustavo Martini
 */
public class Estacionamento {

    private int codigo;
    private int vagas;
    private int veiculosEstacionados;
    private int totalVeiculos;
    private double valorArrecadado;
    public static final Double VALOR_HORA = 3.00;

    public Estacionamento(int vagasMaximo) {
        this.codigo = EstacionamentoDAO.tamanho();
        vagas = vagasMaximo;
        veiculosEstacionados = 0;
        valorArrecadado = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getVeiculosEstacionados() {
        return veiculosEstacionados;
    }

    public void ocuparVaga() {
            this.veiculosEstacionados++;
            totalVeiculos++;
            System.out.println("Veículo liberado!\n");
    }

    public void liberarVaga(Ticket ticket) {
        this.veiculosEstacionados--;
        valorArrecadado += ticket.valorAtual();
    }

    public int vagasLivres() {
        return getVagas() - getVeiculosEstacionados();
    }

    public int getTotalVeiculos() {
        return totalVeiculos;
    }
    
    public double getValorArrecadado() {
        return valorArrecadado;
    }

    @Override
    public String toString() {
        return "Código do estacionamento: " + getCodigo()
                + "\nNúmero total de vagas: " + getVagas()
                + "\nVagas livres: " + vagasLivres();
    }

}
