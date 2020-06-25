/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class Capuccino {
    
    private final int QTDE_PO_CAFE = 3; //bebida 50ml
    private final int QTDE_ACHOCOLATADO = 5; //bebida 50ml
    private final int QTDE_LEITE = 15; //bebida 50ml
    private int acucar;
    private int qtdePoDeCafeFinal;
    private int qtdeAchocolatadoFinal;
    private int qtdeLeiteFinaL;

    public Capuccino(boolean isDoce, boolean isGrande) {
        qtdePoDeCafeFinal = QTDE_PO_CAFE;
        qtdeAchocolatadoFinal = QTDE_ACHOCOLATADO;
        qtdeLeiteFinaL = QTDE_LEITE;
        acucar = 0;
        if (isDoce) {
            acucar = 7;
        }
        if (isGrande) {
            qtdePoDeCafeFinal *= 2;
            qtdeAchocolatadoFinal *= 2;
            qtdeLeiteFinaL *= 2;
            acucar *= 2;
        }
    }
    
    public void fazBebida() {
        /*
        checa ingredientes
        */
        
        if (Ingredientes.checaIngredientes("açúcar", acucar)
                && Ingredientes.checaIngredientes("pó de café", qtdePoDeCafeFinal)
                && Ingredientes.checaIngredientes("achocolatado", qtdeAchocolatadoFinal)
                && Ingredientes.checaIngredientes("leite", qtdeLeiteFinaL)) {
            
            Ingredientes.diminuiAcucar(acucar);
            Ingredientes.diminuiPoDeCafe(qtdePoDeCafeFinal);
            Ingredientes.diminuiAchocolatado(qtdeAchocolatadoFinal);
            Ingredientes.diminuiLeite(qtdeLeiteFinaL);
            
        } else {
            System.out.println("A bebida ainda não foi feita!\n"
                    + "Agora que você encheu o(s) reservatório(s) você deve retomar a seleção da bebida!");
        }
    }
}
