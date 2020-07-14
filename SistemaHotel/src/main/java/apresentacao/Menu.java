/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import javax.swing.JOptionPane;
import negocio.Quarto;
import negocio.QuartoFamilia;
import negocio.QuartoSimples;
import negocio.QuartoTriplo;
import persistencia.QuartoDAO;

/**
 *
 * @author gustavo
 */
public class Menu {

    public void exibir() {
        
        QuartoDAO.recuperaDados();
        
        int op = -1;
        while (op != 0) {
            op = Integer.parseInt(JOptionPane.showInputDialog("----- Operar Quartos -----\n\n"
                    + "[1] Cadastrar quarto\n"
                    + "[2] Consultar quartos\n"
                    + "[3] Movimentação\n\n"
                    + "[0] Salvar e sair"));

            switch (op) {
                case 1:
                    int tipoQuarto = Integer.parseInt(JOptionPane.showInputDialog("----- Operar Quartos -----\n\n"
                            + "[1] Quarto simples\n"
                            + "[2] Quarto triplo\n"
                            + "[3] Quarto família\n"));
                    int numero = Integer.parseInt(
                            JOptionPane.showInputDialog("Informe o número do quarto: "));
                    double valor = Double.parseDouble(
                            JOptionPane.showInputDialog("Informe o valor da diária: "));
                    boolean fumante = (JOptionPane
                            .showInputDialog("Quarto para fumantes? (digite sim ou não)")
                            .charAt(0) == 's');
                    
                switch (tipoQuarto) {
                    case 1:
                        QuartoDAO.create(new QuartoSimples(valor, numero, fumante));
                        break;
                    case 2:
                        QuartoDAO.create(new QuartoTriplo(valor, numero, fumante));
                        break;
                    case 3:
                        QuartoDAO.create(new QuartoFamilia(valor, numero, fumante));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Quarto não foi criado!"
                                + "\nHouve um problema com suas respostas!"
                                + "\nResponda com mais atenção!");
                        break;
                }
                    break;


                case 2:
                    for (Quarto quarto: QuartoDAO.readAll()) {
                        System.out.println(quarto);
                    }
                    
                    break;

                case 3:
                    Movimentacao mov = new Movimentacao();
                    mov.exibir();
                    break;

                case 0:
                    QuartoDAO.salvaDados();
                    op = 0;
                    break;

                default:
                    System.out.println("Opção não encontrada, digite uma das alternativas válidas.");
                    break;
            }
        }
    }
}
