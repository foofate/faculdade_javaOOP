
package negocio;

import apresentacao.Data;

/**
 *
 * @author Gustavo Martini
 */
public class Emprestimo {
 
    private int codigo;
    private Leitor leitor;
    private Livro livro;
    private Data dataEmprestimo;
    private Data dataDevolucao;

    public Emprestimo(int codigo, Leitor leitor, Livro livro, Data dataEmprestimo) {
        this.codigo = codigo;
        this.leitor = leitor;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Data getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Data dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Data getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Data dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    
    
    @Override
    public String toString() {
        return "Código do Histórico: " + getCodigo()
                + "\nLeitor: "
                + "\n" + getLeitor()
                + "\nLivro: "
                + "\n" + getLivro()
                + "\nData Empréstimo: " + getDataEmprestimo().formatarData(1)
                + "\nData Devolução: " + getDataDevolucao().formatarData(1)
                + "\n";
    }
    
}
