package br.edu.ufersa.questoes;

public abstract class Questao3 {
    private static int soma;
    private static int subtracao;
    private static int multiplicacao;
    private static int divisao;
    private static int resto;

    public static int valA;
    public static int valB;

    

    public static int somar() {
        soma = valA + valB;
        return soma;
    }

    public static int subtrair() {
        subtracao = valA - valB;
        return subtracao;
    }

    public static int multiplicar() {
        multiplicacao = valA * valB;
        return multiplicacao;
    }
    
    public static int dividir() {
        divisao = valA / valB;
        return divisao;
    }
    
    public static int modulo() {
        resto = valA % valB;
        return resto;
    }

    

    public static int getValA() {
        return valA;
    }

    public static void setValA(int valA) {
        Questao3.valA = valA;
    }

    public static int getValB() {
        return valB;
    }

    public static void setValB(int valB) {
        Questao3.valB = valB;
    }
}