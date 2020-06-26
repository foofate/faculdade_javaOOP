/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import apresentacao.Arquivo;
import java.util.ArrayList;
import negocio.Comissionado;
import negocio.ComissionadoComBase;
import negocio.Empregado;
import negocio.Horista;
import negocio.Mensalista;

/**
 *
 * @author gustavo
 */
public class EmpregadoDAO {
    
    private static ArrayList<Empregado> empregados = new ArrayList<>();
    
    public static boolean create(Empregado emp) {
        if (emp != null) {
            empregados.add(emp);
            return true;
        } else {
            return false;
        }
    }
    
    public static ArrayList<Empregado> listAll() {
        return empregados;
    }
    
    public static void salvaDados() {
        String linha = "";
        Arquivo arqSaida = new Arquivo("empregados.csv");
        arqSaida.abrirEscrita();
        
        
        for (Empregado emp: empregados) {
            linha = emp.linhatxt();
            arqSaida.escreverLinha(linha);
        }
        
        arqSaida.fecharArquivo();
        
    }
    
    public static void recuperaDados() {
        empregados.clear();
        String[] dados = new String[6];
        Empregado emp = null;
        
        Arquivo arqEntrada = new Arquivo("empregados.csv");
        arqEntrada.abrirLeitura();
       
        String linha = arqEntrada.lerLinha();
        while (linha != null) {
            dados = linha.split(";");
            
            switch (dados[0]) {
                case "mensalista":
                    emp = new Mensalista(dados[1], dados[2], Double.parseDouble(dados[3]));
                    break;
                    
                case "horista":
                    emp = new Horista(dados[1], dados[2], Double.parseDouble(dados[3]), Double.parseDouble(dados[4]));
                    break;
                    
                case "comissionado":
                    emp = new Comissionado(dados[1], dados[2], Double.parseDouble(dados[3]), Double.parseDouble(dados[4]));
                    break;
                    
                case "comissionadobase":
                    emp = new ComissionadoComBase(dados[1], dados[2], Double.parseDouble(dados[3]), Double.parseDouble(dados[4]), Double.parseDouble(dados[5]));
                    break;
                    
                default:
                    break;
            }
            
            if (emp != null) {
                create(emp);
            }
            
            linha = arqEntrada.lerLinha();
        }
        
        arqEntrada.fecharArquivo();
    }
}
