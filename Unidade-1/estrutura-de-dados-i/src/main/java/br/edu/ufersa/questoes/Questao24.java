package br.edu.ufersa.questoes;

public abstract class Questao24 {
    
    public static double calcPower(int base, int potencia){
        double power = Math.pow(base, potencia);

        return power;
    }

    public static double calcRoot(int base){
        double root = Math.sqrt(base);

        return root;
    }

    public static double calcFactor(int fator){
        double fatorial = Questao23.calcularFatorial(fator);

        return fatorial;
    }
}
