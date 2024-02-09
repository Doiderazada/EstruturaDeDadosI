package questoes;

public class Questao27 {
    private int inverso[];
    private int tamanho = 0;
    
    public Questao27(int vetor[]){
        for (int i : vetor) {
            tamanho++;
        }
        this.inverso = new int[tamanho];
        tamanho--;
        inverterVetor(vetor);
    };

    public int[] getInverso(){
        return this.inverso;
    }
    
    public void setInverso(int[] vetor) {
        this.inverso = vetor;
    }

    public void inverterVetor(int vetor[]){
        for (int i = 0; i < vetor.length; i++) {
            this.inverso[i] = vetor[tamanho-i];
        }
    }

    public String exibirInverso(){
        String saida;

        saida = "";

        for (int i : inverso) {
            saida = saida + "[" + i + "] ";
        }

        return saida;
    }
}
