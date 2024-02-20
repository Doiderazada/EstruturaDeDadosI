package questoes;

public abstract class Questao36 {
    
    public static int calcularFatorial(final int fator){
        if (fator <= 1) return fator;

        int nFator = fator - 1;
        return fator * calcularFatorial(nFator);
    }
}
