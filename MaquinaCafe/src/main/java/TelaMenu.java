/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class TelaMenu {

    private boolean isDoce;
    private boolean isGrande;

    public TelaMenu() {
        isDoce = false;
        isGrande = false;
    }

    public void exibir() {

        int opt = -1;
        int optDoce = 0;
        int optGrande = 0;
        
        while (opt != 0) {
            opt = Entrada.leiaInt("-----MENU DE BEBIDAS-----\n"
                    + "Escolha a sua bebida digitando um número de acordo com a legenda abaixo: -----\n\n"
                    + "Bebidas:\n"
                    + "[1] Café curto\n"
                    + "[2] Café longo\n"
                    + "[3] Café com leite\n"
                    + "[4] Achocolatado\n"
                    + "[5] Capuccino\n\n"
                    + "[6] Quantidade de ingredientes na máquina\n\n"
                    + "[0] Sair\n");

            if (opt != 0 && opt != 6) {
                optGrande = Entrada.leiaInt("----- Qual o tamanho da bebida? -----\n\n"
                        + "[1] 50ml\n"
                        + "[2] 100ml\n");

                optDoce = Entrada.leiaInt("----- Você quer adicionar açúcar na bebida? -----\n\n"
                        + "[1] Sim\n"
                        + "[2] Não\n");
            }
            
            if (optGrande == 2) {
                isGrande = true;
            }
            
            if (optDoce == 1) {
                isDoce = true;
            }

            switch (opt) {

                case 1:
                    CafeCurto cc = new CafeCurto(isDoce, isGrande);
                    cc.fazBebida();
                    break;

                case 2:
                    CafeLongo cl = new CafeLongo(isDoce, isGrande);
                    cl.fazBebida();
                    break;

                case 3:
                    CafeComLeite ccl = new CafeComLeite(isDoce, isGrande);
                    ccl.fazBebida();
                    break;

                case 4:
                    Achocolatado ach = new Achocolatado(isDoce, isGrande);
                    ach.fazBebida();
                    break;

                case 5:
                    Capuccino cap = new Capuccino(isDoce, isGrande);
                    cap.fazBebida();
                    break;
                    
                case 6:
                    System.out.println(Ingredientes.info());
                    break;

                case 0:
                    opt = 0;
                    break;
                    
                default:
                    System.out.println("Ainda não temos esta bebida no catálogo!\n"
                            + "Por favor, informe um número de acordo com a legenda do menu!");
                    break;

            }
        }
    }

}
