package questoes;

public abstract class Questao19 {
    private static int numero;

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Questao19.numero = numero;
    }

    public static String montarTabuada() {
        String tabuada = "";
        int num = getNumero();
        int produto;

        for (int i = 1; i <= 10; i++) {
            produto = num * i;
            tabuada = tabuada + num + " X " + i + " = " + produto + "\n";
        }

        return tabuada;
    }
}
