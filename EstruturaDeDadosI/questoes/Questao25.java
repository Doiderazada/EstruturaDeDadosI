package questoes;

public class Questao25 {
    int vetor[];

    public Questao25(int tamanho){
        this.vetor = new int[tamanho];

    }

    public int[] getVetor() {
        return vetor;
    }

    public void setValor(int posicao, int valor){
        this.vetor[posicao] = valor;
    }

    public int getValor(int posicao){
        return this.vetor[posicao];
    }

    public String exibirVetor(){
        String saida;

        saida = "";

        for (int i : vetor) {
            saida = saida + "[" + i + "] ";
        }

        return saida;
    }
}