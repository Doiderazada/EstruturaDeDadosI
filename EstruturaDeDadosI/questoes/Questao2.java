package questoes;

public abstract class Questao2 {
    private static String nome;
    private static char inicial;
    private static int idade;
    private static float altura;
    
    public static String getNome() {
        return nome;
    }
    public static void setNome(String nome) {
        Questao2.nome = nome;
    }
    public static char getInicial() {
        return inicial;
    }
    public static void setInicial(char inicial) {
        Questao2.inicial = inicial;
    }
    public static int getIdade() {
        return idade;
    }
    public static void setIdade(int idade) {
        Questao2.idade = idade;
    }
    public static float getAltura() {
        return altura;
    }
    public static void setAltura(float altura) {
        Questao2.altura = altura;
    }

    
}
