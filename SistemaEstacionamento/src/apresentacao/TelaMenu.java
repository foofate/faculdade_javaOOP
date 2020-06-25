package apresentacao;

import javax.swing.JOptionPane;
import negocio.Estacionamento;
import negocio.Ticket;
import persistencia.EstacionamentoDAO;
import persistencia.TicketDAO;

/**
 *
 * @author Gustavo Martini
 */
public class TelaMenu {

    public void exibir() {

        String opt = "";

        while (!opt.equals("0")) {

            opt = JOptionPane.showInputDialog("_____MENU ESTACIONAMENTO_____"
                    + "\n"
                    + "\n[1] Cadastrar estacionamento"
                    + "\n[2] Operar estacionamento"
                    + "\n[3] Dados estatísticos de um dos estacionamentos"
                    + "\n[4] Dados estatísticos gerais (de todos estacionamentos)"
                    + "\n[5] Listar estacionamentos cadastrados"
                    + "\n[6] Listar tickets ativos"
                    + "\n"
                    + "\n[0] Sair");

            switch (opt) {
                case "1":
                    EstacionamentoDAO.create(new Estacionamento(Integer.parseInt(JOptionPane
                            .showInputDialog("Informe o número máximo de vagas do novo estacionamento: "))));
                    break;

                case "2":
                    String opt2 = "";

                    int codEstacionamento = Integer.parseInt(JOptionPane
                            .showInputDialog("Informe o código do estacionamento:"));
                    Estacionamento estacionamento = EstacionamentoDAO.getEstacionamento(codEstacionamento);

                    OUTER:
                    while (!opt2.equals("0")) {
                        opt2 = JOptionPane.showInputDialog("_____ESTACIONAMENTO " + codEstacionamento + "_____"
                                + "\n"
                                + "\n[1] Entrada de veículo"
                                + "\n[2] Pagamento ticket e saída de veículo"
                                + "\n"
                                + "\n[0] Voltar");
                        switch (opt2) {
                            case "1":
                                if (estacionamento.vagasLivres() > 0) {
                                    TicketDAO.create(new Ticket(estacionamento));
                                } else {
                                    System.out.println("Não há vagas neste estacionamento!\n");
                                    for (Estacionamento estacionamento1 : EstacionamentoDAO.readAll()) {
                                        if (estacionamento1.vagasLivres() > 0) {
                                            System.out.println("Estacionamento " + estacionamento1.getCodigo()
                                                    + " tem " + estacionamento1.vagasLivres() + " vaga(s) livre(s).\n");
                                        }
                                    }
                                }

                                break;

                            case "2":
                                int codTicket = Integer.parseInt(JOptionPane
                                        .showInputDialog("Informe o código do ticket:"));

                                Ticket ticket = TicketDAO.getTicket(codTicket);

                                if (ticket.getEstacionamento() == estacionamento) {
                                    ticket.pagarTicket(ticket);
                                    estacionamento.liberarVaga(ticket);
                                    System.out.println("Ticket " + ticket.getCodigo() + " pago!\n");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ticket não encontrado para este estacionamento!"
                                            + "\nConsulte a lista de tickets ativos!");
                                }

                                break;

                            case "0":
                                break OUTER;

                            default:
                                JOptionPane.showMessageDialog(null, "Opção inválida!"
                                        + "\nInforme uma opção de acordo com o menu!");
                                break;
                        }
                    }

                    break;

                case "3":
                    String opt3 = "";
                    codEstacionamento = Integer.parseInt(JOptionPane
                            .showInputDialog("Informe o código do estacionamento:"));
                    estacionamento = EstacionamentoDAO.getEstacionamento(codEstacionamento);
                    
                    System.out.println("---DADOS ESTACIONAMENTO " + estacionamento.getCodigo() + "---\n");
                    
                    OUTER:
                    while (!opt3.equals("0")) {
                        opt3 = JOptionPane.showInputDialog("_____MENU ESTACIONAMENTO_____"
                                + "\n"
                                + "\n[1] Quantidade de veículos estacionados neste momento"
                                + "\n[2] Quantidade de veículos totais (todos que entraram)"
                                + "\n[3] Valor arrecadado até o momento"
                                + "\n"
                                + "\n[0] Voltar");

                        if (opt3.equals("1")) {
                            System.out.println("Número de veículos estacionados: " + estacionamento.getVeiculosEstacionados());
                        } else if (opt3.equals("2")) {
                            System.out.println("Total de veículos que entraram: " + estacionamento.getTotalVeiculos());
                        } else if (opt3.equals("3")) {
                            System.out.println("Valor arrecadado: R$" + estacionamento.getValorArrecadado());
                        } else if (opt3.equals("0")) {
                            break OUTER;
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida!"
                                    + "\nInforme uma opção de acordo com o menu!");
                        }
                    }
                    System.out.println();
                    break;

                case "4":
                    String opt4 = "";
                    int totalDeVeiculos = 0;
                    int veiculosEstacionados = 0;
                    double valorArrecadado = 0;
                    
                    System.out.println("---DADOS GERAIS---\n");

                    OUTER:
                    while (!opt4.equals("0")) {
                        opt4 = JOptionPane.showInputDialog("_____MENU ESTACIONAMENTO_____"
                                + "\n"
                                + "\n[1] Quantidade de veículos estacionados neste momento"
                                + "\n[2] Quantidade de veículos totais (todos que entraram)"
                                + "\n[3] Valor arrecadado até o momento"
                                + "\n"
                                + "\n[0] Voltar");
                        
                        if (opt4.equals("1")) {
                            for (Estacionamento est1 : EstacionamentoDAO.readAll()) {
                                veiculosEstacionados += est1.getVeiculosEstacionados();
                            }
                            System.out.println("Número de veículos estacionados: " + veiculosEstacionados);

                        } else if (opt4.equals("2")) {
                            for (Estacionamento est2 : EstacionamentoDAO.readAll()) {
                                totalDeVeiculos += est2.getTotalVeiculos();
                            }
                            System.out.println("Total de veículos que entraram: " + totalDeVeiculos);

                        } else if (opt4.equals("3")) {
                            for (Estacionamento est3 : EstacionamentoDAO.readAll()) {
                                valorArrecadado += est3.getValorArrecadado();
                            }
                            System.out.println("Valor arrecadado: R$" + valorArrecadado);

                        } else if (opt4.equals("0")) {
                            break OUTER;
                        } else {
                            JOptionPane.showMessageDialog(null, "Opção inválida!"
                                    + "\nInforme uma opção de acordo com o menu!");
                        }
                    }
                    System.out.println();
                    break;

                case "5":
                    System.out.println("-----------------------------");
                    System.out.println("Estacionamentos cadastrados: ");
                    System.out.println("-----------------------------");
                    System.out.println();
                    for (Estacionamento estacionamento2 : EstacionamentoDAO.readAll()) {
                        System.out.println(estacionamento2);
                        System.out.println();
                    }
                    System.out.println("-----------------------------\n");
                    break;

                case "6":
                    System.out.println("-----------------------------");
                    System.out.println("Tickets ativos: ");
                    System.out.println("-----------------------------");
                    System.out.println();
                    for (Ticket ticket2 : TicketDAO.readAllAtivos()) {
                        System.out.println(ticket2);
                        System.out.println();
                    }
                    System.out.println("-----------------------------\n");
                    break;

                case "0":
                    JOptionPane.showMessageDialog(null, "Você saiu do sistema!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!"
                            + "\nInforme uma opção de acordo com o menu!");
                    break;

            }

        }
    }
}
