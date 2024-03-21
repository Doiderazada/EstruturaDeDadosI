package br.edu.ufersa.questoes;

public abstract class Questao1 {
    private static final String nome = "João Emanoel Soares Silva";
    private static final char inicial = nome.charAt(0);
    private static final int idade = 23;
    private static final float altura = 1.75f;

    public static String getNome(){
        return nome;
    }

    public static char getInicial() {
        return inicial;
    }

    public static int getIdade() {
        return idade;
    }

    public static float getAltura() {
        return altura;
    }
}
