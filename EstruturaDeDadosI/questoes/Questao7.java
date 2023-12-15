package questoes;

public abstract class Questao7 {
    private static double valA;
    private static double valB;
    private static double resultado;
    
    
    public static double getValA() {
        return valA;
    }
    public static void setValA(double valA) {
        Questao7.valA = valA;
    }
    public static double getValB() {
        return valB;
    }
    public static void setValB(double valB) {
        Questao7.valB = valB;
    }
    public static double getResultado() {
        return resultado;
    }
    private static void setResultado(double resultado) {
        Questao7.resultado = resultado;
    }
    
    
    
    public static double dividir() {
        double result = getValA() / getValB();

        setResultado(result);

        return getResultado();
    }
}
