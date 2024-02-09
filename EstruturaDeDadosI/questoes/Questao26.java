package questoes;

public class Questao26 {
    int matriz[][];
    int line, column;

    public Questao26(int linhas, int colunas){
        this.matriz = new int[linhas][colunas];
        this.line = linhas;
        this.column = colunas;
    }

    public void setValor(int linha, int coluna, int valor){
        this.matriz[linha][coluna] = valor;
    }

    public int getValor(int linha, int coluna){
        return this.matriz[linha][coluna];
    }

    public String exibirMatriz(){
        String saida;

        saida = "";
        
        for (int[] is : matriz) {
            for (int i : is) {
                saida += "[" + i + "] ";
                
            }
            saida += "\n"; 
        }

        return saida;
    }
}