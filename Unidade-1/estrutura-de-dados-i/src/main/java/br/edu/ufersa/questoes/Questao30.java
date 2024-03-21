package br.edu.ufersa.questoes;

public class Questao30 {
    private String fraseOriginal;
    private String fraseInvertida;
    
    
    public Questao30(String frase, boolean inverte) {
        this.setFraseOriginal(frase);
        if (inverte) 
            inverterFrase();
    }


    
    public String getFraseOriginal() {
        return this.fraseOriginal;
    }
    public void setFraseOriginal(String frase) {
        this.fraseOriginal = frase;
    }


    public String getFraseInvertida() {
        return this.fraseInvertida;
    }
    public void setFraseInvertida(String frase) {
        this.fraseInvertida = frase;
    }




    public void inverterFrase(){
        String fraseTemp = "";
        int fim = fraseOriginal.length()-1;
        
        for (int i = 0; i < fraseOriginal.length(); i++) {
            fraseTemp += fraseOriginal.charAt(fim-i);
        }
        setFraseInvertida(fraseTemp);
    }



    public String toString(){
        String classe = getClass().getName() + "\n\n" + 
            "Atributos \n" + 
            "String: fraseOriginal -> "+ getFraseOriginal() + "\n" +
            "String: fraseInvertida -> " + getFraseInvertida() + "\n";

        return classe;
    }
}