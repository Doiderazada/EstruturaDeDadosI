package questoes;

public class Questao2 {
    private String nome;
    private char inicial;
    private int idade;
    private float altura;
    
    public Questao2() {
    }

    public Questao2(String nome, char inicial, int idade, float altura) {
        this.setNome(nome);
        this.setInicial(inicial);
        this.setIdade(idade);
        this.setAltura(altura);
    }



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getInicial() {
        return inicial;
    }
    public void setInicial(char inicial) {
        this.inicial = inicial;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    

    public String toString(){
        String classe = getClass().getName() + "\n\n" + 
            "Atributos \n" + 
            "String: nome -> " + getNome() +"\n" +
            "char: inicial -> " + getInicial() + "\n" +
            "int: idade -> " + getIdade() + "\n" +
            "float: altura -> " + getAltura() + "\n";

        return classe;
    }
}
