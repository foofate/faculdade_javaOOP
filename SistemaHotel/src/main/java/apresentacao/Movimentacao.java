/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import javax.swing.JOptionPane;
import negocio.Quarto;
import negocio.Situacao;
import persistencia.QuartoDAO;

/**
 *
 * @author gustavo
 */
public class Movimentacao {

    public void exibir() {
        int op = -1;
        int numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do quarto: "));
        Quarto quarto = QuartoDAO.movimentarQuarto(numeroQuarto);
        while (op != 0) {
            op = Integer.parseInt(JOptionPane
                    .showInputDialog("----- Movimentação Quarto nº " + numeroQuarto + "-----\n\n"
                            + "[1] Recebe hóspede\n"
                            + "[2] Saída hóspede\n"
                            + "[3] Limpar quarto\n"
                            + "[4] Desativar quarto\n"
                            + "[5] Reativar quarto\n\n"
                            + "[0] Voltar"));

            switch (op) {
                case 1:
                    if (quarto.getSituacao() == Situacao.LIVRE) {
                        quarto.ocupaQuarto();
                        JOptionPane.showMessageDialog(null, "Check-in realizado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Check-in não realizado!"
                                + "\nSituação do quarto: " + quarto.getSituacao());
                    }
                    break;

                case 2:
                    if (quarto.getSituacao() == Situacao.OCUPADO) {
                        QuartoDAO.movimentarQuarto(numeroQuarto).desocupaQuarto();
                        int estadia = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de dias que o hóspede permaneceu no quarto para cálculo do valor final: "));
                        String valorEstadia = "" + QuartoDAO.movimentarQuarto(numeroQuarto).calcularEstadia(estadia);
                        JOptionPane.showMessageDialog(null, "Valor final de estadia: R$" + valorEstadia);
                        JOptionPane.showMessageDialog(null, "O quarto agora está desocupado e aguarda limpeza!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Quarto sem hóspedes ou desativado!");
                    }

                    break;

                case 3:
                    quarto.limpaQuarto();
                    JOptionPane.showMessageDialog(null, "Limpeza do quarto realizada!");
                    break;

                case 4:
                    quarto.desativaQuarto();
                    JOptionPane.showMessageDialog(null, "O quarto foi desativado!");
                    break;

                case 5:
                    quarto.reativaQuarto();
                    JOptionPane.showMessageDialog(null, "Quarto reativado com sucesso!");
                    break;

                case 0:
                    op = 0;
                    break;

                default:
                    System.out.println("Opção não encontrada, digite uma das alternativas válidas.");
                    break;
            }
        }
    }
}
