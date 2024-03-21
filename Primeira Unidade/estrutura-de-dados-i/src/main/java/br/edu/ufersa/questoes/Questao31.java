package br.edu.ufersa.questoes;

import java.io.Serializable;

public class Questao31 implements Serializable {
    private String cpf, nome;
    private int idade;
    private char sexo;
    private double peso, altura, imc;
    private static final long serialVersionUID = 1113799434508676095L;

    

    public Questao31(String cpf, String nome, char sexo, int idade, double peso, double altura) {
        setCpf(cpf);
        setNome(nome);
        setSexo(sexo);
        setIdade(idade);
        setPeso(peso);
        setAltura(altura);

        Questao8 IMC = new Questao8(altura, peso);
        setImc(IMC.getIMC());
        
    }




    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }


    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }


    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }


    public double getImc() {
        return imc;
    }
    public void setImc(double imc) {
        this.imc = imc;
    }


    public String exibirInfoPessoa(){
        String informacao;

        informacao = "Nome: " + getNome() + "\n" +
                     "CPF: " + getCpf() + "\n" +
                     "Sexo: " + getSexo() + "\n" +
                     "Idade: " + getIdade() + " anos" + "\n" +
                     "Altura: " + getAltura() + "m" + "\n" +
                     "Peso: " + getPeso() + "kg" + "\n" +
                     "IMC: " + getImc() + "kg/m²";


        return informacao;
    }



    public String toString(){
        String classe = getClass().getName() + "\n\n" + 
            "Atributos \n" + 
            "String: nome -> " + getNome() + "\n" +
            "String: cpf -> " + getCpf() + "\n" +
            "char: sexo -> " + getSexo() + "\n" +
            "int: idade -> " + getIdade() + "\n" +
            "double: altura -> " + getAltura() + "\n" +
            "double: peso -> " + getPeso() + "\n" +
            "double: imc -> " + getImc() + "\n";

        return classe;
    }
}