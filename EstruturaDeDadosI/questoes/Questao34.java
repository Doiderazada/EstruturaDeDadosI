package questoes;

import java.util.ArrayList;

public class Questao34 {
    private String frase;
    private ArrayList<String> palavras;
    private ArrayList<Integer> quantidade;


    public Questao34(String frase) {
        setFrase(frase);
        setPalavras();
        setQuantidade();
    }


    public String getFrase() {
        return frase;
    }
    public void setFrase(String frase) {
        this.frase = frase;
    }

    public ArrayList<String> getPalavras() {
        return palavras;
    }
    public void setPalavras() {
        this.palavras = new ArrayList<>(1);
    }
    
    public ArrayList<Integer> getQuantidade() {
        return quantidade;
    }
    public void setQuantidade() {
        this.quantidade = new ArrayList<>(1);
    }


    public void contarPalavras(){
        String[] sPalavras = frase.split(" ");

        boolean contem = false;
        int posicao = 0;

        for (String string : sPalavras) {

            if (string.contains(",")) string = string.replace("," , "");
            if (string.contains(".")) string = string.replace("." , "");
            contem = false;

            for (int i = 0; i < palavras.size(); i++) {
                if (palavras.get(i).equals(string)) {
                    contem = true;
                    quantidade.set(i, quantidade.get(i) + 1);
                }
            }

            if (!contem) {
                palavras.add(posicao, string);
                quantidade.add(posicao, 1);
                posicao++;
            }
        }
    }

    
    public String exibirConteudo(){
        String saida = "";

        for (int i = 0; i < palavras.size(); i++) {

            saida = saida + "A palavra \'" + getPalavras().get(i) + "\' repete-se " + 
            getQuantidade().get(i) + " vezes na frase. \n";
        }

        return saida;
    }
    
}
