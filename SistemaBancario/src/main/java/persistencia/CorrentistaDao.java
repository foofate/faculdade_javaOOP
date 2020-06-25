
package persistencia;

import java.util.ArrayList;
import negocio.Correntista;

/**
 *
 * @author Gustavo Martini
 */

// DAO - Data Access Object
public class CorrentistaDao {
    
    private static ArrayList<Correntista> correntistas = new ArrayList<>();
    
    public void create(Correntista correntista) {
//        correntista.setCodigo(correntistas.size());
        correntistas.add(correntista);
    }
    
    public static Correntista getCorrentista(int i) {
        return correntistas.get(i);
    }
    
    public int tamanho() {
        return correntistas.size();
    }
    
    public ArrayList<Correntista> readAll() {
        return correntistas;
    }

//    public void listaCorrentistas() {
//        System.out.println("Correntistas Cadastrados");
//        System.out.println("------------------------");
//        for (int i = 0; i < correntistas.size(); i++) {
//            System.out.println(correntistas.get(i));
//        }
//        System.out.println("------------------------");
//    }
    
}
