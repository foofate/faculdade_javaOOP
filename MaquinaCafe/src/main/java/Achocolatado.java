/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class Achocolatado {

    private final int QTDE_ACHOCOLATADO = 8; //bebida 50ml
    private final int QTDE_LEITE = 20; //bebida 50ml
    private int acucar;
    private int qtdeAchocolatadoFinal;
    private int qtdeLeiteFinaL;

    public Achocolatado(boolean isDoce, boolean isGrande) {
        qtdeAchocolatadoFinal = QTDE_ACHOCOLATADO;
        qtdeLeiteFinaL = QTDE_LEITE;
        acucar = 0;
        if (isDoce) {
            acucar = 7;
        }
        if (isGrande) {
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
                && Ingredientes.checaIngredientes("achocolatado", qtdeAchocolatadoFinal)
                && Ingredientes.checaIngredientes("leite", qtdeLeiteFinaL)) {
            
            Ingredientes.diminuiAcucar(acucar);
            Ingredientes.diminuiAchocolatado(qtdeAchocolatadoFinal);
            Ingredientes.diminuiLeite(qtdeLeiteFinaL);
            
        } else {
            System.out.println("A bebida ainda não foi feita!\n"
                    + "Agora que você encheu o(s) reservatório(s) você deve retomar a seleção da bebida!");
        }

    }

}
