package questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Questao5 {
    private static float valA;
    private static float valB;
    private static float valC;

    public static float getValA() {
        return valA;
    }
    public static float getValB() {
        return valB;
    }
    public static float getValC() {
        return valC;
    }
    public static void setValA(float valA) {
        Questao5.valA = valA;
    }
    public static void setValB(float valB) {
        Questao5.valB = valB;
    }
    public static void setValC(float valC) {
        Questao5.valC = valC;
    }
    
    
    public static float media() {
        float media = (valA + valB + valC) / 3;
        media = (float) BigDecimal.valueOf(media).setScale(3, RoundingMode.HALF_UP).doubleValue();

        return media;
    }
}