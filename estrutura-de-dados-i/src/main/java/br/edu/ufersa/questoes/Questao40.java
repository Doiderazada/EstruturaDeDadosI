package br.edu.ufersa.questoes;

import java.util.HashMap;
import java.util.Map;

public class Questao40 {
    private Map<Character,Character> mapLetras;
    private String fraseOriginal;
    private String fraseCodificada;

    public Questao40() {
        this.mapLetras = new HashMap<Character, Character>();

        gerarMapa();
    }

    


    public String getFraseOriginal() {
        return fraseOriginal;
    }

    public String getFraseCodificada() {
        return fraseCodificada;
    }



    
    private void gerarMapa() {
        this.mapLetras.put('A', 'I');
        this.mapLetras.put('B', 'K');
        this.mapLetras.put('C', 'H');
        this.mapLetras.put('D', 'F');
        this.mapLetras.put('E', 'O');
        this.mapLetras.put('F', 'D');
        this.mapLetras.put('G', 'X');
        this.mapLetras.put('H', 'C');
        this.mapLetras.put('I', 'A');
        this.mapLetras.put('J', 'V');
        this.mapLetras.put('K', 'B');
        this.mapLetras.put('L', 'N');
        this.mapLetras.put('M', 'U');
        this.mapLetras.put('N', 'L');
        this.mapLetras.put('O', 'E');
        this.mapLetras.put('P', 'Z');
        this.mapLetras.put('Q', 'Y');
        this.mapLetras.put('R', 'T');
        this.mapLetras.put('S', 'W');
        this.mapLetras.put('T', 'R');
        this.mapLetras.put('U', 'M');
        this.mapLetras.put('V', 'J');
        this.mapLetras.put('W', 'S');
        this.mapLetras.put('X', 'G');
        this.mapLetras.put('Y', 'Q');
        this.mapLetras.put('Z', 'P');
        this.mapLetras.put('Ç', '/');
        this.mapLetras.put('/', 'Ç');
        this.mapLetras.put('a', 'i');
        this.mapLetras.put('b', 'k');
        this.mapLetras.put('c', 'h');
        this.mapLetras.put('d', 'f');
        this.mapLetras.put('e', 'o');
        this.mapLetras.put('f', 'd');
        this.mapLetras.put('g', 'x');
        this.mapLetras.put('h', 'c');
        this.mapLetras.put('i', 'a');
        this.mapLetras.put('j', 'v');
        this.mapLetras.put('k', 'b');
        this.mapLetras.put('l', 'n');
        this.mapLetras.put('m', 'u');
        this.mapLetras.put('n', 'l');
        this.mapLetras.put('o', 'e');
        this.mapLetras.put('p', 'z');
        this.mapLetras.put('q', 'y');
        this.mapLetras.put('r', 't');
        this.mapLetras.put('s', 'w');
        this.mapLetras.put('t', 'r');
        this.mapLetras.put('u', 'm');
        this.mapLetras.put('v', 'j');
        this.mapLetras.put('w', 's');
        this.mapLetras.put('x', 'g');
        this.mapLetras.put('y', 'q');
        this.mapLetras.put('ç', ':');
        this.mapLetras.put(':', 'ç');
        this.mapLetras.put('z', 'p');
        this.mapLetras.put(' ', '*');
        this.mapLetras.put('*', ' ');
        this.mapLetras.put('1', '9');
        this.mapLetras.put('2', '3');
        this.mapLetras.put('3', '2');
        this.mapLetras.put('4', '8');
        this.mapLetras.put('5', '7');
        this.mapLetras.put('6', '0');
        this.mapLetras.put('7', '5');
        this.mapLetras.put('8', '4');
        this.mapLetras.put('9', '1');
        this.mapLetras.put('0', '6');
    }

    public String codificar(final String frase) {
        this.fraseOriginal = frase;
        char[] letras = frase.toCharArray();
        char[] letrasCodificadas = new char[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            if(mapLetras.containsKey(letras[i]))
                letrasCodificadas[i] = mapLetras.get(letras[i]);
        }
        String textoCodificado = String.copyValueOf(letrasCodificadas);
        return textoCodificado;
    }

    public String decodificar(final String frase) {
        this.fraseCodificada = frase;
        char[] letras = frase.toCharArray();
        char[] letrasCodificadas = new char[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            if (mapLetras.containsKey(letras[i])) {
                letrasCodificadas[i] = mapLetras.get(letras[i]);
            }
        }
        String textoDecodificado = String.copyValueOf(letrasCodificadas);
        return textoDecodificado;
    }
}