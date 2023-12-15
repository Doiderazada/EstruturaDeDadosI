package questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Questao8 {
    private static double altura;
    private static double massa;
    private static double IMC;

    public static double getAltura() {
        return altura;
    }
    public static void setAltura(double altura) {
        Questao8.altura = altura;
    }
    
    public static double getMassa() {
        return massa;
    }
    public static void setMassa(double massa) {
        Questao8.massa = massa;
    }
    
    public static double getIMC() {
        return IMC;
    }
    private static void setIMC(double iMC) {
        IMC = iMC;
    }


    public static double medirIMC() {
        double result = getMassa()/(getAltura()*getAltura());

        Double truncar;
        truncar = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();

        setIMC(truncar);

        return getIMC();
    }
}
