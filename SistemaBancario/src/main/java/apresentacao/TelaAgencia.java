package apresentacao;

import apresentacao.*;
import java.util.ArrayList;
import negocio.*;
import persistencia.ContaBancariaDao;
import persistencia.CorrentistaDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author gustavo
 */
public class TelaAgencia {

    public void exibir() {
        int op = -1;
        while (op != 0) {
            op = Entrada.leiaInt("----- M E N U -----\n\n"
                    + "[1] Cadastrar correntista\n"
                    + "[2] Listar correntistas\n"
                    + "[3] Cadastrar conta corrente\n"
                    + "[4] Listar contas\n"
                    + "[5] Operar contas\n"
                    + "[6] Cadastrar conta poupança\n"
                    + "[7] Listar poupanças\n"
                    + "[8] Operar poupanças\n\n"
                    + "[0] Terminar operações");

            switch (op) {
                case 1:
                    Correntista correntista = new Correntista(Entrada.leiaString("Informe o Nome Correntista"),
                            Entrada.leiaString("Informe o Telefone Correntista"),
                            Entrada.leiaString("Informe o Endereço Correntista"));

                    CorrentistaDao dao = new CorrentistaDao();
                    correntista.setCodigo(dao.tamanho()); //regra de negócio
                    dao.create(correntista);

                    System.out.println("Dados da conta: "
                            + "\nNúmero: " + correntista.getCodigo()
                            + "\nNome: " + correntista.getNome()
                            + "\nTelefone: " + correntista.getTelefone()
                            + "\nEndereço: " + correntista.getEndereco());
                    System.out.println();
                    System.out.println();
//                    System.out.println(correntista);
                    break;

                case 2:
                    CorrentistaDao dao2 = new CorrentistaDao();
                    ArrayList<Correntista> correntistas = new ArrayList<>();
                    correntistas = dao2.readAll();
                    System.out.println("------------------------");
                    System.out.println("Correntistas cadastrados");
                    System.out.println("------------------------");
                    for (Correntista crt : correntistas) {
                        System.out.println(crt);
                    }
                    System.out.println("------------------------");
                    System.out.println();
                    break;

                case 3:
                    int codCorrentista = Entrada.leiaInt("Informe o código do Correntista");

                    ContaBancaria conta = new ContaBancaria(
                            CorrentistaDao.getCorrentista(codCorrentista),
                            Entrada.leiaDouble("Valor do limite de crédito"));

                    ContaBancariaDao cbdao = new ContaBancariaDao();
                    conta.setNumero(cbdao.tamanho());
                    cbdao.create(conta);
                    break;

                case 4:
                    ContaBancariaDao cbdao2 = new ContaBancariaDao();
                    ArrayList<ContaBancaria> contas = new ArrayList<>();
                    contas = cbdao2.readAll();
                    System.out.println("------------------------");
                    System.out.println("Contas cadastradas");
                    System.out.println("------------------------");
                    for (ContaBancaria cnt : contas) {
                        System.out.println(cnt);
                    }
                    System.out.println("------------------------");
                    System.out.println();
                    break;

                case 5:
                    int numeroConta = Entrada.leiaInt("Digite o número da conta: ");
                    TelaConta telaConta = new TelaConta(ContaBancariaDao.getContaBancaria(numeroConta));
                    telaConta.exibir();
                    break;

//                case 6:
//                    codCorrentista = Entrada.leiaInt("Informe o código do Correntista");
//                    
//                    
//
//                    ContaPoupanca poupanca = new ContaPoupanca(Entrada.leiaDouble("Informe o reajuste percentual da conta"),
//                            Correntista.getCorrentista(codCorrentista),
//                            Entrada.leiaDouble("Valor do limite de crédito"));
//
//                    poupanca.addConta(poupanca);
//                    break;
//                    
//                case 7:
//                    ContaPoupanca.listaContas();
//                    break;
//
//                case 8:
//                    numeroConta = Entrada.leiaInt("Digite o número da conta: ");
//                    TelaConta telaPoupanca = new TelaConta(ContaPoupanca.getContaPoupanca(numeroConta));
//                    telaPoupanca.exibir();
//                    break;

                case 0:
                    System.out.println("Obrigado por usar este maravilhoso sistema!");
                    break;

                default:
                    System.out.println("Opção não encontrada, digite uma das alternativas válidas.");
                    break;
            }
        }
    }
}
