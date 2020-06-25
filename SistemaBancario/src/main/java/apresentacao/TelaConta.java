package apresentacao;

import apresentacao.*;
import negocio.*;
import persistencia.ContaBancariaDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gustavo
 */
public class TelaConta {

    private ContaBancaria contaBancaria;
    private ContaPoupanca contaPoupanca;
    private Correntista correntista;

    public TelaConta(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
        correntista = contaBancaria.getCorrentista();
    }

    public TelaConta(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
        correntista = contaPoupanca.getCorrentista();
    }

    public void exibir() {
        int op = -1;
        while (op != 0) {
            op = Entrada.leiaInt("----- Operar Conta -----\n\n"
                    + "[1] Depósito\n"
                    + "[2] Saque\n"
                    + "[3] Pagar Boleto\n"
                    + "[4] Descontar Cheque\n"
                    + "[5] Transferência\n"
                    + "[6] Alterar Limite de Crédito\n"
                    + "[7] Desbloquear Conta\n\n"
                    + "[0] Voltar");

            switch (op) {
                case 1:
                    double valorDeposito = Entrada.leiaDouble("Informe o valor para depósito: ");
                    contaBancaria.deposito(valorDeposito);
                    break;

                case 2:
                    double valorSaque = Entrada.leiaDouble("Informe o valor para saque: ");
                    contaBancaria.saque(valorSaque);
                    break;

                case 3:
                    double valorBoleto = Entrada.leiaDouble("Informe o valor do boleto: ");
                    contaBancaria.pgtoBoleto(valorBoleto);
                    break;

                case 4:
                    double valorCheque = Entrada.leiaDouble("Informe o valor do cheque: ");
                    contaBancaria.compensCheque(valorCheque);
                    break;

                case 5:
                    int outraConta = Entrada.leiaInt("Informe o número da conta para qual você deseja realizar a transferência: ");
                    double valorTransf = Entrada.leiaDouble("Informe o valor para transferência: ");
                    contaBancaria.transferencia(ContaBancariaDao.getContaBancaria(outraConta), valorTransf);
                    break;

                case 6:
                    double novoLimite = Entrada.leiaDouble("Digite o novo limite da conta: ");
                    contaBancaria.setLimiteCredito(novoLimite);
                    break;

                case 7:
                    contaBancaria.desbloquearConta();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção não encontrada, digite uma das alternativas válidas.");
                    break;
            }
        }
    }
}

