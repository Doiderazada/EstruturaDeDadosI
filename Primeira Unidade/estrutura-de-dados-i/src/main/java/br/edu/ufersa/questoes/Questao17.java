package br.edu.ufersa.questoes;

public abstract class Questao17 {
    private static int numInicial;
    private static int numFinal;
    
    
    
    public static int getNumInicial() {
        return numInicial;
    }
    public static void setNumInicial(int numInicial) {
        Questao17.numInicial = numInicial;
    }
    
    public static int getNumFinal() {
        return numFinal;
    }
    public static void setNumFinal(int numFinal) {
        Questao17.numFinal = numFinal;
    }

    public static String contarFor() {
        String resultado = "";
        int resto = getNumInicial() % 2;
        
        if (getNumInicial() < getNumFinal()) {

            if (resto == 1) {
                for(int i = getNumInicial(); i <= getNumFinal(); i++){
                    resultado = resultado + i + " ";
                    i++;
                }
            }else {
                for(int i = getNumInicial() + 1; i <= getNumFinal(); i++){
                    resultado = resultado + i + " ";
                    i++;
                }
            }

        } else {

            if (resto == 1) {
                for(int i = getNumInicial(); i <= getNumFinal(); i--){
                    resultado = resultado + i + " ";
                    i--;
                }
            }else {
                for(int i = getNumInicial() + 1; i <= getNumFinal(); i--){
                    resultado = resultado + i + " ";
                    i--;
                }
            }

        }

        return resultado;
    }
    
    public static String contarWhile() {
        String resultado = "";
        int cont = getNumInicial();
        int resto = getNumInicial() % 2;

        if (getNumInicial() < getNumFinal()) {
            
            
            if (resto == 1) {
                while (cont <= getNumFinal()) {
                    resultado = resultado + cont + " ";
                    cont += 2;
                }
            } else {
                cont = getNumInicial() + 1;
                while (cont <= getNumFinal()) {
                    resultado = resultado + cont + " ";
                    cont += 2;
                }
            }

        } else {

            if (resto == 1) {
                while (cont >= getNumFinal()) {
                    resultado = resultado + cont + " ";
                    cont -= 2;
                }
            } else {
                cont = getNumInicial() + 1;
                while (cont >= getNumFinal()) {
                    resultado = resultado + cont + " ";
                    cont -= 2;
                }
            }
        }

        return resultado;
    }

    public static String contarDoWhile() {
        String resultado = "";
        int cont = getNumInicial();
        int resto = getNumInicial() % 2;

        if (getNumInicial() < getNumFinal()) {            
            
            if (resto == 1){
                do {
                    resultado = resultado + cont + " ";
                    cont += 2;
                } while (cont <= getNumFinal());
            } else {
                cont = getNumInicial() + 1;
                do {
                    resultado = resultado + cont + " ";
                    cont += 2;
                } while (cont <= getNumFinal());
            }

        } else {

            if (resto == 1) {
                do {
                    resultado = resultado + cont + " ";
                    cont -= 2;
                } while (cont >= getNumFinal());
            } else {
                cont = getNumInicial() - 1;
                do {
                    resultado = resultado + cont + " ";
                    cont -= 2;
                } while (cont >= getNumFinal());
            }
        }

        return resultado;
    }
}
