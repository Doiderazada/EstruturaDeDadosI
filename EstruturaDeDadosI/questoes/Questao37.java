package questoes;

public abstract class Questao37 {
    

    public static int calcularComLoopFor(final int numIni, final int numFin){
        int soma = numIni;

        if (numIni < numFin) 
            for (int i = numIni+1; i <= numFin; i++) {
                soma += i;
            }
        else 
            for (int i = numIni-1; i >= numFin; i--) {
                soma += i;
            }
        

        return soma;
    }


    public static int calcularComLoopWhile(final int numIni, final int numFin){
        int soma = 0;

        if (numIni < numFin){
            int cont = numIni;
            while (cont <= numFin){
                soma += cont;
                cont++;
            }
        } else {
            int cont = numIni;
            while (cont >= numFin) {
                soma += cont;
                cont--;
            }
        }

        return soma;
    }


    public static int calcularComRecursao(final int numIni, final int numFin){
        int valor = numIni;

        System.out.println();
        if (valor+1 == numFin) return valor + numFin;

        if (valor < numFin) 
            return valor + calcularComRecursao(valor+1, numFin);
        else 
            return valor + calcularComRecursao(valor-1, numFin);

    }
}
