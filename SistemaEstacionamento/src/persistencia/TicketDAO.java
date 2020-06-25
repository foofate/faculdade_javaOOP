package persistencia;

import java.util.ArrayList;
import negocio.Ticket;

/**
 *
 * @author Gustavo Martini
 */
public class TicketDAO {

    private static final ArrayList<Ticket> TICKETS = new ArrayList<>();

    private static ArrayList<Ticket> ticketsAtivos = new ArrayList<>();

    public static void create(Ticket ticket) {
        TICKETS.add(ticket);
        ticketsAtivos.add(ticket);
    }

    public static int tamanho() {
        return TICKETS.size();
    }

    public static Ticket getTicket(int i) {
        return TICKETS.get(i);
    }

    public static ArrayList<Ticket> readAll() {
        return TICKETS;
    }

    public static ArrayList<Ticket> readAllAtivos() {
        return ticketsAtivos;
    }

    public static void removeTicketAtivo(int codTicket) {
        int contador = 0;
        for (Ticket ticket : ticketsAtivos) {
            if (ticket.getCodigo() == codTicket) {
                contador = ticketsAtivos.lastIndexOf(ticket);
            }
        }
        
        ticketsAtivos.remove(contador);
    }
}
