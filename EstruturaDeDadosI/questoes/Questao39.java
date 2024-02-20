package questoes;

import java.util.ArrayList;
import java.util.List;

public class Questao39<T extends Object> {
    private List<T> listaElementos;
    private List<T> elementosRemovidos;
    private List<T> elementosModificados;

    public Questao39() {
        this.listaElementos = new ArrayList<>();
        this.elementosModificados = new ArrayList<>();
        this.elementosRemovidos = new ArrayList<>();
    }

    public boolean create(T elemento) {
        return this.listaElementos.add(elemento);
    }

    public T read(int posicao) {
        return this.listaElementos.get(posicao);
    }

    public List<T> readAll() {
        return this.listaElementos;
    }

    public boolean update(T elemento, int posicao) {
        return this.elementosModificados.add(this.listaElementos.set(posicao, elemento));
    }

    public boolean updateAll(T[] elementos, int[] posicoes) {
        if (elementos.length != posicoes.length) 
            return false;

        boolean adicionado = false;

        for (int i = 0; i < posicoes.length; i++) {
            adicionado = elementosModificados.add(this.listaElementos.set(posicoes[i], elementos[i]));
            if (!adicionado) 
                break;
        }

        return adicionado;
    }

    public boolean delete(int posicao) {
        return this.elementosRemovidos.add(this.listaElementos.remove(posicao));
    }
    
    public boolean deleteAll() {
        this.listaElementos.clear();
        
        return this.listaElementos.isEmpty();
    }



    public List<T> getModificados() {
        return this.elementosModificados;
    }
    public List<T> getRemovidos() {
        return this.elementosRemovidos;
    }

}
