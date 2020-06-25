
package persistencia;

import apresentacao.Arquivo;
import java.util.ArrayList;
import negocio.Leitor;

/**
 *
 * @author Gustavo Martini
 */
public class LeitorDao {
    
    static ArrayList<Leitor> leitores = new ArrayList<>();
    static ArrayList<Integer> historicoEmprestimoLeitores = new ArrayList<>();
    
    public static void create(Leitor leitor) {
        leitores.add(leitor);
    }
    
    public static Leitor getLeitor(int i) {
        return leitores.get(i);
    }
    
    public static int tamanho() {
        return leitores.size();
    }
    
    public static ArrayList<Leitor> readAll() {
        return leitores;
    }
    
    public static void salva() {
        
        String linha = "";
        
        Arquivo arqSaida = new Arquivo("leitores.txt");
        arqSaida.abrirEscrita();
        
        for (Leitor leitor: leitores) {
            linha = leitor.getNome() + ";" + leitor.getEmail();
            arqSaida.escreverLinha(linha);
        }
        
        arqSaida.fecharArquivo();
    }
    
    public static void recupera() {
        leitores.clear();
        
        String linha = "";
        String[] dados = new String[2];
        Leitor leitor;
        
        Arquivo arqEntrada = new Arquivo("leitores.txt");
        arqEntrada.abrirLeitura();
        linha = arqEntrada.lerLinha();
        
        while (linha != null) {
            dados = linha.split(";");
            leitor = new Leitor(dados[0], dados[1]);
            LeitorDao.create(leitor);
            
            linha = arqEntrada.lerLinha();
        }
        
        arqEntrada.fecharArquivo();
    }
    
}
