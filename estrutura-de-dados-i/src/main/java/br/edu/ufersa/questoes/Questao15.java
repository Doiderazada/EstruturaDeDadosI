package br.edu.ufersa.questoes;

public abstract class Questao15 {
    private static byte numero;

    public static byte getNumero() {
        return numero;
    }

    public static void setNumero(byte numero) {
        Questao15.numero = numero;
    }

    public static String verificarNumero() {

        switch (getNumero()) {
            case 1:
                return "Um";
            case 2:
                return "Dois";
            case 3:
                return "Três";
            case 4:
                return "Quatro";
            case 5:
                return "Cinco";
            default:
                break;
        }

        return "Valor inválido";
    }
}
