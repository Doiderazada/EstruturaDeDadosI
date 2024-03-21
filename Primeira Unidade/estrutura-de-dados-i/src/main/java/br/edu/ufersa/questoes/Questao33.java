package br.edu.ufersa.questoes;

import java.util.ArrayList;

public class Questao33 {
    private String frase;
    private ArrayList<Character> letras;
    private ArrayList<Integer> quantidade;

    
    
    public Questao33(String frase) {
        setFrase(frase);
        setLetras();
        setQuantidade();
        
	}



	public String getFrase() {
        return frase;
    }
    public void setFrase(String novaFrase) {
        this.frase = novaFrase;
    }


    public ArrayList<Character> getLetras() {
        return letras;
    }
    public void setLetras() {
        this.letras = new ArrayList<>(1);
    }


    public ArrayList<Integer> getQuantidade() {
        return quantidade;
    }
    public void setQuantidade() {
        this.quantidade = new ArrayList<>(1);
    }
    

    
    public void contarLetras(){

        char[] vetorChar = getFrase().toCharArray();

        int posicao = 0;
        boolean contem = false;
        
        for (char c : vetorChar) {
            contem = false;
            for (int j = 0; j < letras.size(); j++) {
                if (letras.get(j) == c) {
                    contem = true;
                    quantidade.set(j, quantidade.get(j) + 1);
                }
            }

            if (!contem) {
                this.getLetras().add(posicao, c);
                this.getQuantidade().add(posicao, 1);
                posicao++;
            }
        }
    }

    public String exibirConteudo(){
        String saida = "";

        for (int i = 0; i < letras.size(); i++) {

            saida = saida + "O caractere \'" + getLetras().get(i) + "\' repete-se " + 
            getQuantidade().get(i) + " vezes na frase. \n";
        }
        return saida;
    }



    
}
