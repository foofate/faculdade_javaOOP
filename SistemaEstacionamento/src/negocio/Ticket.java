package negocio;

import java.util.Calendar;
import java.util.Date;
import persistencia.TicketDAO;

/**
 *
 * @author Gustavo Martini
 */
public class Ticket {

    private final Estacionamento estacionamento;
    private int codigo;
    private final int horaEntrada;
    private int horaSaida;
    private Calendar entrada;
    private Calendar saida;
    private boolean pago;

    //trocar Date pelo Calendar --> Calendar cal = Calendar.getInstance() --> cal.getTime()
    
    public Ticket(Estacionamento estacionamento) {
        this.codigo = TicketDAO.tamanho();
        this.estacionamento = estacionamento;
        this.estacionamento.ocuparVaga();
        this.horaEntrada = Calendar.HOUR;
        this.pago = false;
        setEntrada();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public Date getEntrada() {
        return entrada.getTime();
    }

    public void setEntrada() {
        this.entrada = Calendar.getInstance();
    }

    public Date getSaida() {
        return saida.getTime();
    }

    public void setSaida() {
        this.saida = Calendar.getInstance();
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public int getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(int horaSaida) {
        this.horaSaida = horaSaida;
    }

    public double valorAtual() {
        int horaAtual = Calendar.HOUR;
        double valorAtual = ((horaAtual - horaEntrada) + 1) * Estacionamento.VALOR_HORA;

        return valorAtual;
    }

    public void pagarTicket(Ticket ticket) {
        ticket.setSaida();
        ticket.setPago(true);
        TicketDAO.removeTicketAtivo(ticket.getCodigo());
    }

    @Override
    public String toString() {
        return "Código do ticket: " + getCodigo()
                + "\nEstacionamento: " + getEstacionamento().getCodigo()
                + "\nHora de entrada: " + getEntrada()
                + "\nValor atual: R$" + valorAtual()
                + "\nPago: " + isPago();
    }

}
