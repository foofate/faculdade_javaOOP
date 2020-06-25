/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class CafeCurto {
    
    private final int QTDE_PO_CAFE = 3; //bebida 50ml
    private int acucar;
    private int qtdePoDeCafeFinal;

    public CafeCurto(boolean isDoce, boolean isGrande) {
        qtdePoDeCafeFinal = QTDE_PO_CAFE;
        acucar = 0;
        if (isDoce) {
            acucar = 7;
        }
        if (isGrande) {
            qtdePoDeCafeFinal *= 2;
            acucar *= 2;
        }
    }
    
    public void fazBebida() {
        /*
        checa ingredientes
        */
        
        Ingredientes.diminuiAcucar(acucar);
        Ingredientes.diminuiPoDeCafe(qtdePoDeCafeFinal);
        
        if (Ingredientes.checaIngredientes("açúcar", acucar)
                && Ingredientes.checaIngredientes("pó de café", qtdePoDeCafeFinal)) {
            
            Ingredientes.diminuiAcucar(acucar);
            Ingredientes.diminuiAchocolatado(qtdePoDeCafeFinal);
            
        } else {
            System.out.println("A bebida ainda não foi feita!\n"
                    + "Agora que você encheu o(s) reservatório(s) você deve retomar a seleção da bebida!");
        }
    }
}
