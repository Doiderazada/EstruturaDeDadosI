package br.edu.ufersa.questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Questao13 {
    private static double nota1;
    private static double nota2;
    private static double nota3;
    private static double nota4;
    private static double media;
    
    
    
    public static double getNota1() {
        return nota1;
    }
    public static void setNota1(double nota1) {
        Questao13.nota1 = nota1;
    }

    public static double getNota2() {
        return nota2;
    }
    public static void setNota2(double nota2) {
        Questao13.nota2 = nota2;
    }

    public static double getNota3() {
        return nota3;
    }
    public static void setNota3(double nota3) {
        Questao13.nota3 = nota3;
    }

    public static double getNota4() {
        return nota4;
    }
    private static void setNota4(double nota4) {
        Questao13.nota4 = nota4;
    }
    
    public static double getMedia() {
        return media;
    }
    private static void setMedia(double media) {
        Questao13.media = media;
    }

    
    public static String calcularMedia() {
        double med = (getNota1() + getNota2() + getNota3())/3;

        med = BigDecimal.valueOf(med).setScale(2, RoundingMode.HALF_UP).doubleValue();

        double n4 = (50 - (med*6))/4;

        n4 = BigDecimal.valueOf(n4).setScale(2, RoundingMode.HALF_UP).doubleValue();
        setNota4(n4);

        setMedia(med);

        String situacao = "";

        if (media >= 7) situacao = "Aluno aprovado";

        if (media < 7) situacao = "Aluno em recuperação";

        if (media < 3.5) situacao = "Aluno reprovado";
        

        return situacao;
    }
    
    
}
