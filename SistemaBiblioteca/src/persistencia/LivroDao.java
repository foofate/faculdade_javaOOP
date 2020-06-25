package persistencia;

import apresentacao.Arquivo;
import apresentacao.Data;
import java.util.ArrayList;
import negocio.Livro;

/**
 *
 * @author Gustavo Martini
 */
public class LivroDao {

    static ArrayList<Livro> livros = new ArrayList<>();
    static ArrayList<Integer> historicoEmprestimoLivros = new ArrayList<>();
    static ArrayList<Data> historicoEmprestimoDatas = new ArrayList<>();

    public static void create(Livro livro) {
        livros.add(livro);
    }
    
    public static Livro getLivro(int i) {
        return livros.get(i);
    }

    public static int tamanho() {
        return livros.size();
    }
    
    public static ArrayList<Livro> readAll() {
        return livros;
    } 
    
    public static void salva() {
        
        String linha = "";
        
        Arquivo arqSaida = new Arquivo("livros.txt");
        arqSaida.abrirEscrita();
        
        for (Livro livro: livros) {
            linha = livro.getTitulo()+ ";" + livro.getAutor();
            arqSaida.escreverLinha(linha);
        }
        
        arqSaida.fecharArquivo();
    }
    
    public static void recupera() {
        livros.clear();
        
        String linha = "";
        String[] dados = new String[2];
        Livro livro;
        
        Arquivo arqEntrada = new Arquivo("livros.txt");
        arqEntrada.abrirLeitura();
        linha = arqEntrada.lerLinha();
        
        while (linha != null) {
            dados = linha.split(";");
            livro = new Livro(dados[0], dados[1]);
            LivroDao.create(livro);
            
            linha = arqEntrada.lerLinha();
        }
        
        arqEntrada.fecharArquivo();
    }
    
}
