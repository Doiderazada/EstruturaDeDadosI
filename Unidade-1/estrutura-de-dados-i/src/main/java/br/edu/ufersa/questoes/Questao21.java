package br.edu.ufersa.questoes;

public abstract class Questao21 {
    
    private static int mult = 0;



    public static int getMult() {
        return mult;
    }
    private static void setMult(int mult) {
        Questao21.mult = mult;
    }



    public static boolean verificarPrimo(int num) {

        if (num % 2 == 0) {
            if (num == 2) return true;
            
            setMult(2);
            return false;

        } else {

            if (num == 3 || num == 5 || num == 7) return true;

            int contador = 2;
            int result3, result5, result7;

            do {
                result3 = 3 * contador;
                result5 = 5 * contador;
                result7 = 7 * contador;

                if (result3 == num) {
                    setMult(3);
                    return false;
                }
                
                if (result5 == num) {
                    setMult(5);
                    return false;
                }
                
                if (result7 == num) {
                    setMult(7);
                    return false;
                }

                contador++;
            } while (result3 < num);

            return true;
        }
    }

}