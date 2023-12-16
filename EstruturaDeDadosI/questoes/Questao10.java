package questoes;

public abstract class Questao10 {
    private static int numero;
    private static int multiplo;
    
    
    
    public static int getNumero() {
        return numero;
    }
    public static void setNumero(int numero) {
        Questao10.numero = numero;
    }
    

    public static int getMultiplo() {
        return multiplo;
    }
    public static void setMultiplo(int multiplo) {
        Questao10.multiplo = multiplo;
    }


    
    public static boolean verificarParidade() {
        int result = getNumero() % 2;

        if (result == 0) {
            int mult = 0;
            while (result < getNumero()) {
                mult++;
                result = mult * 2;
            }
            setMultiplo(mult);
            return true;
        }

        return false;
    }
    
}