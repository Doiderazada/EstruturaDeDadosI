package br.edu.ufersa.questoes;

public abstract class Questao4 {
    private static int valA;
    private static int valB;
    private static int valC;

    public static int getValA() {
        return valA;
    }
    public static int getValB() {
        return valB;
    }
    public static int getValC() {
        return valC;
    }
    public static void setValA(int valA) {
        Questao4.valA = valA;
    }
    public static void setValB(int valB) {
        Questao4.valB = valB;
    }
    public static void setValC(int valC) {
        Questao4.valC = valC;
    }
    
    
    public static int media() {
        int media = (valA + valB + valC) / 3;
        return media;
    }
}