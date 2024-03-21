package br.edu.ufersa.questoes;

public class Questao29 {
    private String inversoString;
    private int[] vetorInverso;


    public Questao29(int[] vetor) {
        vetorInverso = new int[vetor.length];
        this.setVetorInverso(vetor);
        this.setInversoString("");
    }


    public int[] getVetorInverso() {
        return vetorInverso;
    }
    public void setVetorInverso(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            this.vetorInverso[i] = vetor[i];
        }
    }


    public String getInversoString() {
        return inversoString;
    }
    private void setInversoString(String string) {
        inversoString = string;
    }



    public void moverElemento(){
        int temp, cont = 1;
        String vetorExibido, inverso;


        this.setInversoString("");
        for (int i = this.vetorInverso.length-1; i > 0; i--) {
            
            temp = this.vetorInverso[i];
            this.vetorInverso[i] = this.vetorInverso[i-1];
            this.vetorInverso[i-1] = temp;

            vetorExibido = exibirVetor(this.vetorInverso);
            inverso = getInversoString();

            setInversoString(inverso + cont + "º iteração: " + vetorExibido + "\n");
            cont++;
        }
    }


    public String exibirVetor(int[] vetor){
        String saida = "";

        for (int i : vetor) {
            saida = saida + "[" + i + "] ";
        }

        return saida;
    }


    
}