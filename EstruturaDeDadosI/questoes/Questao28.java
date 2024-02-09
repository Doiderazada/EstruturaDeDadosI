package questoes;

public abstract class Questao28 {
    static int maior, menor;


    public static int getMaior(){
        return maior;
    }
    public static void setMaior(int higher){
        maior = higher;
    }


    public static int getMenor(){
        return menor;
    }
    public static void setMenor(int lower){
        menor = lower;
    }


    public static void calcMaxMin(int[] vetor){
        setMaior(vetor[0]);
        setMenor(vetor[0]);

        for (int i = 0; i < vetor.length; i++) {
            
            if (vetor[i] < getMenor()) setMenor(vetor[i]);
            if (vetor[i] > getMaior()) setMaior(vetor[i]);
        }
    }
}