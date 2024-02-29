package questoes;

public abstract class Questao23 {
    private static int fator;


    public static int getFator() {
        return fator;
    }
    private static void setFator(int fator) {
        Questao23.fator = fator;
    }


    public static double calcularFatorial(int fator) {
        
        setFator(fator);
        double fatorial = fator;

        for (int i = 1; i < fator; i++) {
            fatorial *= i;
        }

        return fatorial;
    }
}