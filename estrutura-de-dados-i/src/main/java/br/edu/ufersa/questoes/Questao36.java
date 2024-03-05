package br.edu.ufersa.questoes;

public abstract class Questao36 {
    
    public static double calcularFatorial(final int fator){
        if (fator <= 1) return fator;

        int nFator = fator - 1;
        return fator * calcularFatorial(nFator);
    }
}
