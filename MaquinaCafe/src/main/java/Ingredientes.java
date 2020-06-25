/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class Ingredientes {

    private static int poDeCafe;
    private static int acucar;
    private static int leite;
    private static int achocolatado;

    public Ingredientes() {
        poDeCafe = 500;
        acucar = 500;
        leite = 500;
        achocolatado = 500;
    }

    public static int getPoDeCafe() {
        return poDeCafe;
    }

    public static void addPoDeCafe(int poDeCafe) {
        Ingredientes.poDeCafe += poDeCafe;
    }

    public static void diminuiPoDeCafe(int poDeCafe) {
        Ingredientes.poDeCafe -= poDeCafe;
    }

    public static int getAcucar() {
        return acucar;
    }

    public static void addAcucar(int acucar) {
        Ingredientes.acucar += acucar;
    }

    public static void diminuiAcucar(int acucar) {
        Ingredientes.acucar -= acucar;
    }

    public static int getLeite() {
        return leite;
    }

    public static void addLeite(int leite) {
        Ingredientes.leite += leite;
    }

    public static void diminuiLeite(int leite) {
        Ingredientes.leite -= leite;
    }

    public static int getAchocolatado() {
        return achocolatado;
    }

    public static void addAchocolatado(int achocolatado) {
        Ingredientes.achocolatado += achocolatado;
    }

    public static void diminuiAchocolatado(int achocolatado) {
        Ingredientes.achocolatado -= achocolatado;
    }

    public static boolean checaIngredientes(String ingrediente, int quantidade) {
        String ingredienteEmFalta = new String();
        boolean quantidadeSuficiente = true;
        
        if (ingrediente.equals("pó de café") && poDeCafe <= quantidade) {
            quantidadeSuficiente = false;
            ingredienteEmFalta = "pó de café";
        }
        if (ingrediente.equals("açúcar") && acucar <= quantidade) {
            quantidadeSuficiente = false;
            ingredienteEmFalta = "açúcar";
        }
        if (ingrediente.equals("leite") && leite <= quantidade) {
            quantidadeSuficiente = false;
            ingredienteEmFalta = "leite";
        }
        if (ingrediente.equals("achocolatado") && achocolatado <= quantidade) {
            quantidadeSuficiente = false;
            ingredienteEmFalta = "achocolatado";
        }
        if (!quantidadeSuficiente) {
            int qtdeIngredienteAdd;
            if (ingrediente.equals("pó de café")) {
                qtdeIngredienteAdd = Entrada.leiaInt(String.format("Não há quantidade suficiente do ingrediente %s para o preparo da bebida!\n\n", ingredienteEmFalta)
                                                        + "Informe a quantidade que será adicionada ao reservatório do ingrediente pó de café: ");
                addPoDeCafe(qtdeIngredienteAdd);
                System.out.println("Adicionados " + qtdeIngredienteAdd + "g.");
            }
            if (ingrediente.equals("açúcar")) {
                qtdeIngredienteAdd = Entrada.leiaInt(String.format("Não há quantidade suficiente do ingrediente %s para o preparo da bebida!\n\n", ingredienteEmFalta)
                                                        + "Informe a quantidade que será adicionada ao reservatório do ingrediente açúcar: ");
                addAcucar(qtdeIngredienteAdd);
                System.out.println("Adicionados " + qtdeIngredienteAdd + "g.");
            }
            if (ingrediente.equals("leite")) {
                qtdeIngredienteAdd = Entrada.leiaInt(String.format("Não há quantidade suficiente do ingrediente %s para o preparo da bebida!\n\n", ingredienteEmFalta)
                                                        + "Informe a quantidade que será adicionada ao reservatório do ingrediente leite: ");
                addLeite(qtdeIngredienteAdd);
                System.out.println("Adicionados " + qtdeIngredienteAdd + "g.");
            }
            if (ingrediente.equals("achocolatado")) {
                qtdeIngredienteAdd = Entrada.leiaInt(String.format("Não há quantidade suficiente do ingrediente %s para o preparo da bebida!\n\n", ingredienteEmFalta)
                                                        + "Informe a quantidade que será adicionada ao reservatório do ingrediente achocolatado: ");
                addAchocolatado(qtdeIngredienteAdd);
                System.out.println("Adicionados " + qtdeIngredienteAdd + "g.");
            }
        }
        
        return quantidadeSuficiente;
    }
        
    public static String info() {
        return ("QUANTIDADE DE INGREDIENTES NA MÁQUINA (g):"
                + "\n\nAçúcar: " + getAcucar()
                + "\nPó de café: " + getPoDeCafe()
                + "\nLeite: " + getLeite()
                + "\nAchocolatado: " + getAchocolatado()
                + "\n\n");
    }

}
