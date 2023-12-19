package questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Questao14 {
    private static double termoA;
    private static double termoB;
    private static double termoC;
    private static double delta;
    private static double x1;
    private static double x2;
    
    
    
    public static double getTermoA() {
        return termoA;
    }
    public static void setTermoA(double termoA) {
        Questao14.termoA = termoA;
    }

    public static double getTermoB() {
        return termoB;
    }
    public static void setTermoB(double termoB) {
        Questao14.termoB = termoB;
    }

    public static double getTermoC() {
        return termoC;
    }
    public static void setTermoC(double termoC) {
        Questao14.termoC = termoC;
    }


    public static double getDelta() {
        return delta;
    }
    private static void setDelta(double delta) {
        Questao14.delta = delta;
    }

    public static double getX1() {
        return x1;
    }
    private static void setX1(double x1) {
        Questao14.x1 = x1;
    }

    public static double getX2() {
        return x2;
    }
    private static void setX2(double x2) {
        Questao14.x2 = x2;
    }


    

    public static void calcularRaiz() {
        
        double tempDelta = (getTermoB()*getTermoB()) - (4*getTermoA()*getTermoC());
        setDelta(tempDelta);

        double tx1 = ((-1)*getTermoB() + Math.sqrt(getDelta())) / (2*getTermoA());
        double tx2 = ((-1)*getTermoB() - Math.sqrt(getDelta())) / (2*getTermoA());

        tx1 = BigDecimal.valueOf(tx1).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        tx2 = BigDecimal.valueOf(tx2).setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        setX1(tx1);
        setX2(tx2);

    }
    
}