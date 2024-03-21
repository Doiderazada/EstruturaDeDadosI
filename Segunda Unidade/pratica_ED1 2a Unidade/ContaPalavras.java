package pratica_ED1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import pratica_ED1.Classes.DoiderasSinglyLinkedList;
import pratica_ED1.Interfaces.DoiderasList;

public class ContaPalavras {


    private DoiderasList<String> listaDePalavras = new DoiderasSinglyLinkedList<>();
    private Map<String, Integer> mapaPalavras = new HashMap<String, Integer>();

    private final File arquivoEntrada = new File("pratica_ED1/arquivos/ArquivoEntrada.txt");
    private final File arquivoBinario = new File("pratica_ED1/arquivos/BinSaved.bin");
    private final File arquivoTexto = new File("pratica_ED1/arquivos/TxtSaved.txt");

    public ContaPalavras() {
        lerArquivoEntrada();
        contarPalavrasLidas();
        salvarBinario();
        salvarTexto();
    }


    private void lerArquivoEntrada() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada));
            String linhas;

            while ((linhas = reader.readLine()) != null) {
                
                String[] palavrasLidas = linhas.split(" ");
                for (String string : palavrasLidas) {
                    listaDePalavras.add(string);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("\n");
            e.printStackTrace();
        }
    }



    private void contarPalavrasLidas() {
        while (listaDePalavras.isEmpty() != true) {
            String palavra = listaDePalavras.get(0);
            int quantidade;

            if (mapaPalavras.containsKey(palavra)) {
                quantidade = mapaPalavras.get(palavra);
                mapaPalavras.put(palavra, quantidade+1);
            } else mapaPalavras.put(palavra, 1);

            listaDePalavras.removeFirst();
        }
    }

    

    private void salvarBinario() {
        try {
            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arquivoBinario));
            objOutput.writeObject(mapaPalavras);

            objOutput.close();

        } catch (Exception e) {
            e.getMessage();
            System.out.println("\n");
            e.printStackTrace();
        }
    }

    private void salvarTexto() {
        try {
            
            PrintWriter writer = new PrintWriter(arquivoTexto);
            for (Map.Entry<String, Integer> entry : mapaPalavras.entrySet()) {
                writer.println("A palavra: " + entry.getKey() + " aparece " + entry.getValue() + " vezes.");
            }
            writer.close();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("\n");
            e.printStackTrace();
        }
    }



    
    @SuppressWarnings("unchecked")
    public String abrirBinario() {
        String textoLido = "";
        try {
            ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arquivoBinario));
            mapaPalavras = (HashMap<String, Integer>) objInput.readObject();

            for (Map.Entry<String, Integer> entry : mapaPalavras.entrySet()) {
                textoLido += "A palavra: " + entry.getKey() + " aparece " + entry.getValue() + " vezes. \n";
            }

            objInput.close();
            
        } catch (Exception e) {
            e.getMessage();
            System.out.println("\n");
            e.printStackTrace();
        }

        return textoLido;
    }

    public String abrirTexto() {
        String textoLido = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoTexto));
            String linhas;

            while ((linhas = reader.readLine()) != null) {
                textoLido += linhas + "\n";
            }
            reader.close();
        } catch (Exception e) {
            e.getMessage();
            System.out.println("\n");
            e.printStackTrace();
        } 
        
        return textoLido;
    }    
}
