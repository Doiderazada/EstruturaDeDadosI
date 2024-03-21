package br.edu.ufersa.questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Questao9 {
    private static double raio;
    private static double circunferencia;
    private static double area;
    
    
    
    public static double getRaio() {
        return raio;
    }
    public static void setRaio(double raio) {
        Questao9.raio = raio;
    }
    
    public static double getCircunferencia() {
        return circunferencia;
    }
    private static void setCircunferencia(double circunferencia) {
        Questao9.circunferencia = circunferencia;
    }
    
    public static double getArea() {
        return area;
    }
    private static void setArea(double area) {
        Questao9.area = area;
    }


    public static double medirCircunferencia() {
        double result = 2 * Math.PI * getRaio();
        
        result = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();

        setCircunferencia(result);

        return getCircunferencia();
    }

    public static double medirArea() {
        double result = 2 * Math.PI * Math.pow(getRaio(), 2);

       result = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
        
        setArea(result);

        return getArea();
    }
    
}
