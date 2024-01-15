package questoes;

public abstract class Questao22 {
    

    public static int fazerSomatorio(int numIni, int numFin) {
        int soma = numIni;

        if (numIni < numFin) {
            for (int i = numIni+1; i <= numFin; i++) {
                soma += i;
            }
        } else {
            for (int i = numIni-1; i >= numFin; i--) {
                soma += i;
            }
        }

        return soma;
    }
}
