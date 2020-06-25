package apresentacao;

import javax.swing.JOptionPane;
import negocio.Emprestimo;
import negocio.Livro;
import negocio.Leitor;
import persistencia.EmprestimoDao;
import persistencia.LivroDao;
import persistencia.LeitorDao;

/**
 *
 * @author Gustavo Martini
 */
public class TelaMenu {

    public void exibir() {

        String opt = "-1";
        
        LeitorDao.recupera();
        LivroDao.recupera();
        EmprestimoDao.recupera();

        while (!opt.equals("0")) {
            opt = JOptionPane.showInputDialog("Menu da Biblioteca:"
                    + "\n"
                    + "\n[1] Cadastrar leitor"
                    + "\n[2] Consultar leitores cadastrados"
                    + "\n[3] Cadastrar livro"
                    + "\n[4] Consultar livros cadastrados"
                    + "\n[5] Retirada"
                    + "\n[6] Devolução"
                    + "\n[7] Histórico de retiradas"
                    + "\n"
                    + "\n[0] Sair");

            switch (opt) {
                case "1":
                    LeitorDao.create(new Leitor(JOptionPane.showInputDialog("Nome: "),
                            JOptionPane.showInputDialog("Email: ")));
                    break;

                case "2":
                    System.out.println("--- LEITORES CADASTRADOS ---");
                    for (Leitor leitor : LeitorDao.readAll()) {
                        System.out.println("Cód.: " + leitor.getCodigo()
                                + "\nNome: " + leitor.getNome()
                                + "\nEmail: " + leitor.getEmail());
                        System.out.println();
                    }
                    break;

                case "3":
                    LivroDao.create(new Livro(JOptionPane.showInputDialog("Título: "),
                            JOptionPane.showInputDialog("Autor: ")));
                    break;

                case "4":
                    System.out.println("--- LIVROS CADASTRADOS ---");
                    for (Livro livro : LivroDao.readAll()) {
                        System.out.println("Cód.: " + livro.getCodigo()
                                + "\nTítulo: " + livro.getTitulo()
                                + "\nAutor: " + livro.getAutor()
                                + "\nDisponível: " + livro.isDisponivel());
                        System.out.println();
                    }
                    break;

                case "5":
                    int codLeitor = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do leitor:"));
                    int codLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro:"));
                    Livro.emprestar(LeitorDao.getLeitor(codLeitor), LivroDao.getLivro(codLivro));
                    System.out.println("O leitor " + LeitorDao.getLeitor(codLeitor).getNome()
                            + " retirou o livro " + LivroDao.getLivro(codLivro).getTitulo() + ".");
                    System.out.println();
                    break;

                case "6":
                    codLeitor = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do leitor:"));
                    codLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro:"));
                    Livro.devolver(LeitorDao.getLeitor(codLeitor), LivroDao.getLivro(codLivro));
                    System.out.println("O leitor " + LeitorDao.getLeitor(codLeitor).getNome()
                            + " devolveu o livro " + LivroDao.getLivro(codLivro).getTitulo() + ".");
                    System.out.println();
                    break;

                case "7":
                    String opt2 = JOptionPane.showInputDialog(""
                            + "[1] Histórico do Leitor\n"
                            + "[2] Histórico do Livro\n"
                            + "\n"
                            + "[0] Voltar");

                    if (opt2.equals("1")) {
                        codLeitor = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do leitor:"));
                        System.out.println("--- HISTÓRICO LEITOR ---");
                        for (Emprestimo historico : EmprestimoDao.readAll()) {
                            if (historico.getLeitor().getCodigo() == codLeitor) {
                                System.out.println(historico);
                            }
                        }
                        System.out.println();
                        
                    } else if (opt2.equals("2")) {
                        codLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro:"));
                        System.out.println("--- HISTÓRICO LIVRO ---");
                        for (Emprestimo historico : EmprestimoDao.readAll()) {
                            if (historico.getLivro().getCodigo() == codLivro) {
                                System.out.println(historico);
                            }
                        }
                        System.out.println();
                        
                    } else if (opt2.equals("0")) {
                        break;
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Digite um comando válido.");
                    }
                    break;

                case "0":
                    LeitorDao.salva();
                    LivroDao.salva();
                    EmprestimoDao.salva();
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Digite um comando válido!");
                    break;
            }
        }
    }
}
