package negocio;

import apresentacao.Data;
import java.util.ArrayList;
import persistencia.EmprestimoDao;
import persistencia.LivroDao;

/**
 *
 * @author Gustavo Martini
 */
public class Livro {

    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private int ultimoEmprestimo;

    public Livro(String titulo, String autor) {
        this.codigo = LivroDao.tamanho();
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getUltimoEmprestimo() {
        return ultimoEmprestimo;
    }

    public void setUltimoEmprestimo(int ultimoEmprestimo) {
        this.ultimoEmprestimo = ultimoEmprestimo;
    }

    @Override
    public String toString() {
        return "--- Título: " + getTitulo()
                + "\n--- Autor: " + getAutor()
                + "\n";
    }

    /* 
        Método para empréstimo de livro que tem como parâmetros o livro e o leitor.
        Após empréstimo o livro fica como indisponível até sua devolução.
        Cria um histórico na data de empréstimo.
     */
    public static boolean emprestar(Leitor leitor, Livro livro) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            livro.setUltimoEmprestimo(EmprestimoDao.tamanho());
            EmprestimoDao.create(new Emprestimo(EmprestimoDao.tamanho(), leitor, livro, new Data()));
            return true;
        } else {
            return false;
        }
    }

    /* 
        Método para devolução de livro que tem como parâmetros o livro e o leitor.
        Após devolução o livro volta a ficar disponível e seta a data de devolução no histórico
            através do atributo ultimoEmprestimo.    
     */
    public static boolean devolver(Leitor leitor, Livro livro) {
        if (!livro.isDisponivel()) {
            livro.setDisponivel(true);
            int codigoHistorico = livro.getUltimoEmprestimo();
            Data dataDevolucao = new Data();
            EmprestimoDao.getHistorico(codigoHistorico).setDataDevolucao(dataDevolucao);

            //multa
            Data dataEmprestimo = EmprestimoDao.getHistorico(codigoHistorico).getDataEmprestimo();
            int diasEmprestimo = dataDevolucao.compareTo(dataEmprestimo);
            if (diasEmprestimo > 7) {
                System.out.println("O LEITOR DEVE PAGAR MULTA POR ATRASO"
                        + "\nNA DEVOLUÇÃO DO LIVRO!"
                        + "\nNúmero de dias atrasados: " + (diasEmprestimo - 7));
            } else {
                System.out.println("O LEITOR DEVOLVEU DENTRO DO PRAZO DE 7 DIAS.");
            }
            return true;
        } else {
            return false;
        }
    }

}
