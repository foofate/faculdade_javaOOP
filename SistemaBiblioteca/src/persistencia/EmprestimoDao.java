package persistencia;

import apresentacao.Arquivo;
import apresentacao.Data;
import java.util.ArrayList;
import negocio.Emprestimo;
import negocio.Leitor;
import negocio.Livro;

/**
 *
 * @author Gustavo Martini
 */
public class EmprestimoDao {

    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void create(Emprestimo historico) {
        emprestimos.add(historico);
    }

    public static Emprestimo getHistorico(int i) {
        return emprestimos.get(i);
    }

    public static int tamanho() {
        return emprestimos.size();
    }

    public static ArrayList<Emprestimo> readAll() {
        return emprestimos;
    }

    public static void salva() {

        String linha = "";

        Arquivo arqSaida = new Arquivo("emprestimos.txt");
        arqSaida.abrirEscrita();

        for (Emprestimo emprestimo : emprestimos) {
            
            linha = emprestimo.getCodigo() + ";"
                    + emprestimo.getLivro().getCodigo() + ";"
                    + emprestimo.getLeitor().getCodigo() + ";"
                    + emprestimo.getDataEmprestimo().toString() + ";"
                    + (emprestimo.getDataDevolucao() != null ? emprestimo.getDataDevolucao().toString() : " ");
            arqSaida.escreverLinha(linha);
        }

        arqSaida.fecharArquivo();
    }

    public static void recupera() {
        emprestimos.clear();

        String linha = "";
        String[] dados = new String[5];
        Emprestimo emprestimo;

        Arquivo arqEntrada = new Arquivo("emprestimos.txt");
        arqEntrada.abrirLeitura();
        linha = arqEntrada.lerLinha();

        while (linha != null) {
            dados = linha.split(";");

            Livro livro = null;
            Leitor leitor = null;

            for (Leitor lt : LeitorDao.leitores) {
                if (lt.getCodigo() == Integer.parseInt(dados[2])) {
                    leitor = lt;
                }
            }

            for (Livro lv : LivroDao.livros) {
                if (lv.getCodigo() == Integer.parseInt(dados[1])) {
                    livro = lv;
                }
            }

            Data d = new Data(dados[3]);

            emprestimo = new Emprestimo(Integer.parseInt(dados[0]),
                    leitor,
                    livro,
                    d);

            emprestimo.setDataDevolucao(new Data(dados[4]));
            
            EmprestimoDao.create(emprestimo);

            linha = arqEntrada.lerLinha();
        }

        arqEntrada.fecharArquivo();
    }
}
