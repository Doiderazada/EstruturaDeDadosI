package br.edu.ufersa.questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public  class Questao8 {
    private double altura;
    private double massa;
    private double IMC;

    
    public Questao8(double altura, double massa) {
        setAltura(altura);
        setMassa(massa);

        medirIMC();
    }


    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double getMassa() {
        return massa;
    }
    public void setMassa(double massa) {
        this.massa = massa;
    }
    
    public double getIMC() {
        return IMC;
    }
    private void setIMC(double iMC) {
        IMC = iMC;
    }


    public double medirIMC() {
        double result = this.massa/(this.altura*this.altura);

        Double truncar;
        truncar = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();

        setIMC(truncar);

        return getIMC();
    }
}
