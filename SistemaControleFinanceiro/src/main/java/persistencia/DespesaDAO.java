/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import negocio.Despesa;
import apresentacao.Arquivo;
import negocio.Categoria;

/**
 *
 * @author gustavo
 */
public class DespesaDAO {

    private static ArrayList<Despesa> despesas = new ArrayList<>();

    public static void create(Despesa despesa) {
        despesas.add(despesa);
    }

    public static ArrayList<Despesa> readAll() {
        return despesas;
    }

    public static double totalDespesas() {
        double valor = 0.0;

        for (Despesa despesa : despesas) {
            valor += despesa.getValor();
        }

        return valor;
    }

    public static String totalDespesasMes(Categoria categoria) {
        double valor = 0.0;
        String retorno = "Categoria " + categoria + "\n\n";
        
        for (Despesa despesa : despesas) {
            if (despesa.getCategoria() == categoria) {
                valor += despesa.getValor();
                retorno += "Valor: R$" + despesa.getValor() + "\nDescrição: " + despesa.getDescricao() + "\n\n";
            }
        
        }
        retorno += "Valor total: R$" + valor;
        
        return retorno;
    }

    public static void zerarDespesas() {
        despesas.clear();
    }

    public static void salvaDados() {
        String linha = "";
        Arquivo arqSaida = new Arquivo("despesas.csv");
        arqSaida.abrirEscrita();

        for (Despesa despesa : despesas) {
            linha = despesa.lineToPersist();
            arqSaida.escreverLinha(linha);
        }

        arqSaida.fecharArquivo();

    }

    
    
    public static void recuperaDados() {
        despesas.clear();
        String[] dados = new String[3];
        Categoria cat = null;
        Despesa despesa = null;
        
        Arquivo arqEntrada = new Arquivo("despesas.csv");
        arqEntrada.abrirLeitura();
       
        String linha = arqEntrada.lerLinha();
        while (linha != null) {
            dados = linha.split(";");
            
            switch (dados[0]) {
                case "ALIMENTACAO":
                    cat = Categoria.ALIMENTACAO;
                    break;
                    
                case "LAZER":
                    cat = Categoria.LAZER;
                    break;
                    
                case "VESTUARIO":
                    cat = Categoria.VESTUARIO;
                    break;
                    
                case "TRANSPORTE":
                    cat = Categoria.TRANSPORTE;
                    break;
                    
                case "EDUCACAO":
                    cat = Categoria.EDUCACAO;
                    break;
                    
                case "OUTRAS":
                    cat = Categoria.OUTRAS;
                    break;
                    
                default:
                    break;
            }
            
            despesa = new Despesa(Double.parseDouble(dados[1]), cat, dados[2]);
            
            if (despesa != null) {
                create(despesa);
            }
            
            linha = arqEntrada.lerLinha();
        }
        
        arqEntrada.fecharArquivo();
    }
     
}
