package pratica_ED1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import pratica_ED1.ContaPalavras;

public class Questao5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File arquivo = new File("./pratica_ED1/arquivos/ArquivoEntrada.txt");

        System.out.println("Entre com a frase que deseja contar ");
        System.out.print("Sua frase: ");
        String frase = scanner.nextLine();

        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
            writer.write(frase);
            writer.close();
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }

        scanner.close();
        ContaPalavras contadorDePalavras = new ContaPalavras();

        System.out.println("\n\n\n");
        System.out.println("Aquivo binário aberto:");
        System.out.println(contadorDePalavras.abrirBinario());
        System.out.println("\n\n");

        System.out.println("Aquivo texto aberto:");
        System.out.println(contadorDePalavras.abrirTexto());
        System.out.println("\n\n");


    }
}
