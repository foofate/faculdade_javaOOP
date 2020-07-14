/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import apresentacao.Arquivo;
import java.util.ArrayList;
import negocio.Quarto;
import negocio.QuartoFamilia;
import negocio.QuartoSimples;
import negocio.QuartoTriplo;
import negocio.Situacao;

/**
 *
 * @author gustavo
 */
public class QuartoDAO {
    
    private static ArrayList<Quarto> quartos = new ArrayList<>();
    
    public static void create(Quarto quarto) {
        quartos.add(quarto);
    }
    
    /**
     * Método para fazer operações em um determinado quarto!
     * @param num Número do quarto.
     * @return Quarto com número igual ao informado pelo parâmetro.
     */
    public static Quarto movimentarQuarto(int num) {
        Quarto q = null;
        
        for (Quarto quarto: readAll()) {
            if (quarto.getNumero() == num) {
                q = quarto;
            }
        }
        
        return q;
    }
    
    public static ArrayList<Quarto> readAll() {
        return quartos;
    }

    public static void salvaDados() {
        String linha = "";
        Arquivo arqSaida = new Arquivo("quartos.csv");
        arqSaida.abrirEscrita();

        for (Quarto quarto : quartos) {
            linha = quarto.lineToPersist();
            arqSaida.escreverLinha(linha);
        }

        arqSaida.fecharArquivo();
    }
    
    public static void recuperaDados() {
        quartos.clear();
        String[] dados = new String[5];
        Quarto quarto = null;
        String nomeClasse;
        int numero;
        boolean fumante;
        Situacao situacao = null;
        double valor;
        
        Arquivo arqEntrada = new Arquivo("quartos.csv");
        arqEntrada.abrirLeitura();
        String linha = arqEntrada.lerLinha();
        
        while (linha != null) {
            dados = linha.split(";");
            
            nomeClasse = dados[0];
            numero = Integer.parseInt(dados[1]);
            fumante = Boolean.parseBoolean(dados[2]);
            valor = Double.parseDouble(dados[4]);
            
            switch (dados[3]) {
                case "LIVRE":
                    situacao = Situacao.LIVRE;
                    break;
                    
                case "OCUPADO":
                    situacao = Situacao.OCUPADO;
                    break;
                    
                case "AGUARDANDO_LIMPEZA":
                    situacao = Situacao.AGUARDANDO_LIMPEZA;
                    break;
                    
                case "DESATIVADO":
                    situacao = Situacao.DESATIVADO;
                    break;
                    
                default:
                    break;
            }
            
            switch (nomeClasse) {
                case "QuartoSimples":
                    quarto = new QuartoSimples(valor, numero, fumante);
                    quarto.setSituacao(situacao);
                    break;
                    
                case "QuartoTriplo":
                    quarto = new QuartoTriplo(valor, numero, fumante);
                    quarto.setSituacao(situacao);
                    break;
                    
                case "QuartoFamilia":
                    quarto = new QuartoFamilia(valor, numero, fumante);
                    quarto.setSituacao(situacao);
                    break;
                    
                default:
                    break;
            }
            
            if (quarto != null) {
                create(quarto);
            }
            
            linha = arqEntrada.lerLinha();
        }
        
        arqEntrada.fecharArquivo();
    }
}
