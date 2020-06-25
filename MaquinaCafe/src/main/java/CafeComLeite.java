/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class CafeComLeite {
    
    private final int QTDE_PO_CAFE = 3; //bebida 50ml
    private final int QTDE_LEITE = 10; //bebida 50ml
    private int acucar;
    private int qtdePoDeCafeFinal;
    private int qtdeLeiteFinal;

    public CafeComLeite(boolean isDoce, boolean isGrande) {
        qtdePoDeCafeFinal = QTDE_PO_CAFE;
        qtdeLeiteFinal = QTDE_LEITE;
        acucar = 0;
        if (isDoce) {
            acucar = 7;
        }
        if (isGrande) {
            qtdePoDeCafeFinal *= 2;
            qtdeLeiteFinal *= 2;
            acucar *= 2;
        }
    }
    
    public void fazBebida() {
        /*
        checa ingredientes
        */
        int x = 0;
        while (x == 0) {
            if (Ingredientes.checaIngredientes("açúcar", acucar)
                && Ingredientes.checaIngredientes("pó de café", qtdePoDeCafeFinal)
                && Ingredientes.checaIngredientes("leite", qtdeLeiteFinal)) {
                x = 1;
            }
        }
        
        Ingredientes.diminuiAcucar(acucar);
        Ingredientes.diminuiPoDeCafe(qtdePoDeCafeFinal);
        Ingredientes.diminuiLeite(qtdeLeiteFinal);
        
        if (Ingredientes.checaIngredientes("açúcar", acucar)
                && Ingredientes.checaIngredientes("pó de café", qtdePoDeCafeFinal)
                && Ingredientes.checaIngredientes("leite", qtdeLeiteFinal)) {
            
            Ingredientes.diminuiAcucar(acucar);
            Ingredientes.diminuiPoDeCafe(qtdePoDeCafeFinal);
            Ingredientes.diminuiLeite(qtdeLeiteFinal);
            
        } else {
            System.out.println("A bebida ainda não foi feita!\n"
                    + "Agora que você encheu o(s) reservatório(s) você deve retomar a seleção da bebida!");
        }
    }
}
