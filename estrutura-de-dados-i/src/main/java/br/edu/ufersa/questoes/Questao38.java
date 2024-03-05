package br.edu.ufersa.questoes;

public class Questao38<T extends Object> {
    
    public String exibirObjeto(T obj){
        return obj.toString();
    }

    public String exibirVetorObjeto(T[] objs){
        String saida = "";
        for (T object : objs) {
            saida += "_____________________________\n";
            saida += object.toString() + "\n";
        }
        
        return saida;
    }
}