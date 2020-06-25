
package persistencia;

import java.util.ArrayList;
import negocio.Estacionamento;

/**
 *
 * @author Gustavo Martini
 */
public class EstacionamentoDAO {
    
    private static final ArrayList<Estacionamento> ESTACIONAMENTOS = new ArrayList<>();
    
    public static void create(Estacionamento estacionamento) {
        ESTACIONAMENTOS.add(estacionamento);
    }
    
    public static int tamanho() {
        return ESTACIONAMENTOS.size();
    }
    
    public static Estacionamento getEstacionamento(int i) {
        return ESTACIONAMENTOS.get(i);
    }
    
    public static ArrayList<Estacionamento> readAll() {
        return ESTACIONAMENTOS;
    }
}
