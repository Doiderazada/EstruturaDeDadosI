package questoes;

public abstract class Questao6 {
    private static final float precoFatia =  3.0f;
    private static final float precoRefri =  1.5f;
    private static int quantRefri;
    private static int quantPizza;
    private static float subTotal;
    private static float total;
    private static int quantPessoa;
    private static float valPessoa;
    private static float valPizza;
    private static float valRefri;


    public static float getPrecofatia() {
        return precoFatia;
    }
    public static float getPrecorefri() {
        return precoRefri;
    }
    public static float getQuantRefri() {
        return quantRefri;
    }
    public static float getQuantPizza() {
        return quantPizza;
    }
    public static float getSubTotal() {
        return subTotal;
    }
    public static float getTotal() {
        return total;
    }
    private static float getQuantPessoa() {
        return quantPessoa;
    }
    public static float getValPessoa() {
        return valPessoa;
    }
    public static float getValPizza() {
        return valPizza;
    }
    public static float getValRefri() {
        return valRefri;
    }
    

    

    
    public static void setQuantRefri(int quantRefri) {
        Questao6.quantRefri = quantRefri;
    }
    public static void setQuantPizza(int quantPizza) {
        Questao6.quantPizza = quantPizza;
    }
    public static void setQuantPessoa(int quantPessoa) {
        Questao6.quantPessoa = quantPessoa;
    }
    private static void setSubTotal(float subTotal) {
        Questao6.subTotal = subTotal;
    }
    private static void setTotal(float total) {
        Questao6.total = total;
    }
    private static void setValPessoa(float valPessoa) {
        Questao6.valPessoa = valPessoa;
    }
    private static void setValRefri(float valRefri) {
        Questao6.valRefri = valRefri;
    }
    private static void setValPizza(float valPizza) {
        Questao6.valPizza = valPizza;
    }

    private static float calcularSubTotal() {
        float valPi = ((getQuantPizza() * 8) * precoFatia);
        float valRe = (getQuantRefri() * precoRefri);
        float subT = valPi + valRe;

        setValPizza(valPi);
        setValRefri(valRe);
        setSubTotal(subT);

        return getSubTotal();
    }

    public static float calcularTotal() {
        
        calcularSubTotal();
        
        float taxaGarcon = getSubTotal()*10/100;
        float tTotal = getSubTotal() + taxaGarcon;
        
        setTotal(tTotal);

        float totPessoa = getTotal()/getQuantPessoa();

        setValPessoa(totPessoa);

        return getTotal();
    }
}