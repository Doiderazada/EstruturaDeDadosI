package br.edu.ufersa.questoes;

public abstract class Questao16 {
    private static int numInicial;
    private static int numFinal;
    
    
    
    public static int getNumInicial() {
        return numInicial;
    }
    public static void setNumInicial(int numInicial) {
        Questao16.numInicial = numInicial;
    }
    
    public static int getNumFinal() {
        return numFinal;
    }
    public static void setNumFinal(int numFinal) {
        Questao16.numFinal = numFinal;
    }

    public static String contarFor() {
        String resultado = "";
        
        if (getNumInicial() < getNumFinal()) 
            for(int i = getNumInicial(); i <= getNumFinal(); i++){
                resultado = resultado + i + " ";
            }
        else 
            for(int i = getNumFinal(); i <= getNumInicial(); i--){
                resultado = resultado + i + " ";
            }

        return resultado;
    }
    
    public static String contarWhile() {
        String resultado = "";
        int cont = getNumInicial();

        if (getNumInicial() < getNumFinal()) 
            while (cont <= getNumFinal()) {
                resultado = resultado + cont + " ";
                cont++;
            }
        else 
            while (cont >= getNumFinal()) {
                resultado = resultado + cont + " ";
                cont--;
            }
        

        return resultado;
    }
    public static String contarDoWhile() {
        String resultado = "";
        int cont = getNumInicial();
        if (getNumInicial() < getNumFinal()) 
            do {
                resultado = resultado + cont + " ";
                cont++;
            } while (cont <= getNumFinal());

        else
            do {
                resultado = resultado + cont + " ";
                cont--;
            } while (cont >= getNumFinal());

        return resultado;
    }
}
