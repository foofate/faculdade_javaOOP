
package persistencia;

import java.util.ArrayList;
import negocio.ContaBancaria;

/**
 *
 * @author Gustavo Martini
 */

// DAO - Data Access Object
public class ContaBancariaDao {
    
    static ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();
    
    public void create(ContaBancaria conta) {
        contasBancarias.add(conta);
    }
    
    public static ContaBancaria getContaBancaria(int i) {
        return contasBancarias.get(i);
    }
    
    public int tamanho() {
        return contasBancarias.size();
    }
    
    public ArrayList<ContaBancaria> readAll() {
        return contasBancarias;
    }
    
//    public static void listaContas() {
//        System.out.println("Contas Cadastradas");
//        System.out.println("------------------------");
//        for (int i = 0; i < contasBancarias.size(); i++) {
//            System.out.println(contasBancarias.get(i));
//        }
//        System.out.println("------------------------");
//    }
    
    
    
    
}
