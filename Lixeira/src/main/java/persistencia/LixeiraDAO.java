/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import apresentacao.Arquivo;
import negocio.Lixeira;

/**
 *
 * @author gustavo
 */
public class LixeiraDAO {

    private static Lixeira lixeira;

    public static Lixeira getLixeira() {
        return lixeira;
    }
    
    public static void create(Lixeira lixeira) {
        LixeiraDAO.lixeira = lixeira;
    }

    public static void salvar() {

        String linha;

        Arquivo arqSaida = new Arquivo("lixeira.txt");
        arqSaida.abrirEscrita();

        linha = lixeira.getAltura() + ";" + lixeira.getRaio() + ";" + lixeira.getVolumeAtual();
        arqSaida.escreverLinha(linha);

        arqSaida.fecharArquivo();
    }

    public static boolean recuperar() {
        try {
            String linha;
        String[] dados = new String[3];
        Lixeira lixeira;

        Arquivo arqEntrada = new Arquivo("lixeira.txt");
        arqEntrada.abrirLeitura();

        linha = arqEntrada.lerLinha();
        dados = linha.split(";");
        
        double altura = Double.parseDouble(dados[0]);
        double raio = Double.parseDouble(dados[1]);
        double volumeAtual = Double.parseDouble(dados[2]);
        
        lixeira = new Lixeira(altura, raio);
        lixeira.setVolumeAtual(volumeAtual);
        LixeiraDAO.create(lixeira);

        arqEntrada.fecharArquivo();
        
        return true;
        } catch (Exception e) {
            return false;
        }
        
        
        
    }

}
