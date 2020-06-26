/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.ArrayList;
import negocio.Comissionado;
import negocio.ComissionadoComBase;
import negocio.Empregado;
import negocio.Horista;
import negocio.Mensalista;
import persistencia.EmpregadoDAO;

/**
 *
 * @author gustavo
 */
public class FolhaPagamento {
    public static void main(String[] args) {
        
//        Mensalista emp1 = new Mensalista("Fulano A", "131242312", 1800.0);
//        EmpregadoDAO.create(emp1);
//        Comissionado emp2 = new Comissionado("Ciclano", "12345", 10, 28000);
//        EmpregadoDAO.create(emp2);
//        Horista emp3 = new Horista("Beltrano", "2334", 30, 200);
//        EmpregadoDAO.create(emp3);
//        ComissionadoComBase emp4 = new ComissionadoComBase("Daltano", "43245", 10, 25000, 1800);
//        EmpregadoDAO.create(emp4);
        
        EmpregadoDAO.recuperaDados();

        double totalFolha = 0.0;
        ArrayList<Empregado> colabs = EmpregadoDAO.listAll();
        
        System.out.println("----- PROCESSAMENTO FOLHA DE PAGAMENTOS -----");
        for (Empregado emp: colabs) {
            System.out.println(emp);
            System.out.println("Valor do salário: " + emp.ganhos());
            System.out.println();
            totalFolha += emp.ganhos();
        }
        
        System.out.println("Valor total da folha: " + totalFolha);
        System.out.println();
        
        for (Empregado emp: colabs) {
            System.out.println("Empregado: " + emp.getNome()
                    + "\tClasse: " + emp.getClass().getSimpleName());
        }
        
        EmpregadoDAO.salvaDados();
    }
}
