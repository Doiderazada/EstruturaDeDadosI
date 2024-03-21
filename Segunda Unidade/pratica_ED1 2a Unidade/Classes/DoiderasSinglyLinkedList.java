package pratica_ED1.Classes;

import java.util.Collection;
import java.util.Iterator;

import pratica_ED1.Interfaces.DoiderasList;


public class DoiderasSinglyLinkedList<T> implements DoiderasList<T> {

    private DoiderasNode<T> first;
    private DoiderasNode<T> last;
    private int size;



    public DoiderasSinglyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = first;
    }



    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }
    
    
    
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean containsAll(Collection<?> c) {
        T[] arrayTs = (T[]) c.toArray();
        int length = arrayTs.length;    
        int index = 0;
        boolean contain = false;
        
        do {
            contain = contains(arrayTs[index++]);
            if (index == length) break;
        } while (contain);
        return contain;
    }



    public boolean addFirst(T element) {
        DoiderasNode<T> novo = new DoiderasNode<T>(element);
        novo.setNext(this.first);
        this.first = novo;
        if (this.last == null) this.last = this.first;
        this.size = size()+1;
        return true;
    }
    
    public boolean addLast(T element) {
        DoiderasNode<T> novo = new DoiderasNode<T>(element);
        this.last.setNext(novo);
        this.last = novo;
        this.size = size()+1;
        return true;
    }
    
    public boolean add(T element) {
        if (isEmpty()) return addFirst(element); 
        else return addLast(element);
    }
    
    public void add(int index, T element) {
        DoiderasNode<T> novo = new DoiderasNode<T>(element);
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        if (index >= size() | index < 0) return;
        if (index == size()-1) {
            addLast(element);
            return;
        }
        
        DoiderasNode<T> temp = this.first;
        for (int i = 0; i < index; i++) temp = temp.getNext();
        DoiderasNode<T> next = temp.getNext();
        temp.setNext(novo);
        novo.setNext(next);
        this.size = size()+1;
    }

    

    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends T> c) {
        T[] arrayTs = (T[]) c.toArray();
        int length = arrayTs.length;    int index = 0;
        boolean added = false;
        do {
            added = add(arrayTs[index++]);
            if (index == length) break;
        } while (added);
        return added;
    }
    
    @SuppressWarnings("unchecked")
    public boolean addAll(int index, Collection<T> c) {
        T[] arrayTs = (T[]) c.toArray();
        int length = arrayTs.length;
        DoiderasNode<T>[] nodesToAdd = new DoiderasNode[length];
        int cont = 0;

        DoiderasNode<T> temp = this.first;
        for (int i = 0; i < index; i++) temp = temp.getNext();

        do {
            nodesToAdd[cont] = new DoiderasNode<T>(arrayTs[cont]);
            cont++;
        } while (cont < length);

        for (int i = 0; i < length - 1; i++) {
            nodesToAdd[i].setNext(nodesToAdd[i+1]);
        };

        DoiderasNode<T> next = temp.getNext();
        temp.setNext(nodesToAdd[0]);
        nodesToAdd[length-1].setNext(next);
        size = size() + length;
        return true;
    }
    
    public boolean removeFirst() {
        if (isEmpty()) return false;
        DoiderasNode<T> next = this.first.getNext();
        this.first.setNext(null);
        this.first = next;
        this.size = size()-1;
        return true;
    }
    
    public boolean removeLast() {
        if (isEmpty()) return false;
        DoiderasNode<T> temp = this.first;
        DoiderasNode<T> prev = temp;
        for (int i = 0; i < size()-1; i++) {
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(null);
        this.last = prev;
        this.size = size()-1;
        return true;
    }
    
    public boolean remove(Object e) {
        if (isEmpty()) return false;
        DoiderasNode<T> temp = new DoiderasNode<T>(null);
        temp = this.first;
        DoiderasNode<T> prev = temp;
        int index = 0;
        if (contains(e)) index = lastIndexOf(e);
        if (index == -1) return false;
        
        if (size() == 1) {
            clear();
            return true;
        }
        
        if (index == 0) return removeFirst();
        if (index == (size()-1)) return removeLast();

        temp = this.first;
        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(temp.getNext());
        temp.setNext(null);
        this.size = size()-1;
        return true;
    }
    
    public T remove(int index) {
        if (isEmpty()) return null;
        DoiderasNode<T> temp = this.first;
        DoiderasNode<T> prev = temp;
        T dataToReturn;
        
        if (index <= -1) return null;
        if (index >= size()) return null;
        
        if (index == 0) {
            dataToReturn = (T) this.first.getData();
            removeFirst();
            return dataToReturn;
        }
        if (index == size()-1) {
            dataToReturn = (T) last.getData();
            removeLast();
            return dataToReturn;
        }
        
        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.getNext();
        }
        dataToReturn = temp.getData();
        prev.setNext(temp.getNext());
        temp.setNext(null);
        this.size = size()-1;
        return dataToReturn;
    }
    
    @SuppressWarnings("unchecked")
    public boolean removeAll(Collection<?> c) {
        if (isEmpty()) return false;
        T[] arrayTs = (T[]) c.toArray();
        int length = arrayTs.length;
        boolean removed = false;
        
        for (int i = 0; i < length; i++) {
            removed = remove(arrayTs[i]);
        }
        return removed;
    }
    


    public boolean retainAll(Collection<?> c) {
        if (isEmpty()) return false;

        @SuppressWarnings("unchecked")
        Collection<T> newCol = (Collection<T>) c;
        if (containsAll(newCol)) {
            clear();
            return addAll(newCol);
        }
        return false;
    }
    


    public void clear() {
        this.last = this.first = null;
        this.size = 0;
    }
    


    public T get(int index) {
        DoiderasNode<T> temp = new DoiderasNode<T>(null);
        temp = this.first;
        
        for (int i = 0; i < index; i++) temp = temp.getNext();
        return temp.getData();
    }
    
    public T set(int index, T element) {
        DoiderasNode<T> temp = new DoiderasNode<T>(null);
        temp = this.first;
        
        for (int i = 0; i < index; i++) temp = temp.getNext();
        T dataReplaced = temp.getData();
        temp.setData(element);
        return dataReplaced;
    }
    


    public int indexOf(Object element) {
        if (isEmpty()) return -1;
        DoiderasNode<T> temp;
        int index = 0;
        temp = this.first;
        
        do{    
            if (temp.getData().equals(element)) return index;
            index++;
            temp = temp.getNext();
        } while (temp != null);
        
        return -1;
    }
    
    public int lastIndexOf(Object e) {
        if (isEmpty()) return -1;
        
        int index = indexOf(e);
        int temporaryIndex;
        if (index == -1) return index;
        
        do {
            temporaryIndex = indexBy(index, e);
            if (temporaryIndex == -1) break;
            index = temporaryIndex;
        } while (index != -1);
        
        return index;
    }
    
    private int indexBy(int index, Object e) {
        if (isEmpty()) return -1;
        DoiderasNode<T> temp = new DoiderasNode<T>(null);
        
        temp = this.first;
        for (int i = 0; i <= index; i++) temp = temp.getNext();
        index++;
        
        while (temp != null) {
            if (temp.getData().equals(e)) return index; 
            temp = temp.getNext();      index++;
        } 
        return -1;
    }
    

    
    
    public DoiderasList<T> subList(int initIndex, int finalIndex) {
        DoiderasSinglyLinkedList<T> novaLista = new DoiderasSinglyLinkedList<T>();
        DoiderasNode<T> temp = new DoiderasNode<T>(null);
        temp = this.first;
        
        for (int i = 0; i < initIndex; i++) temp = temp.getNext();
        int cont = initIndex;
        
        do {
            novaLista.add(temp.getData());
            cont++;
            temp = temp.getNext();
        } while (cont < finalIndex);
        return novaLista;
    }
    
    
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        int index = 0;
        int length = size();
        T[] arrayObjects = (T[]) new Object[length];

        for (DoiderasNode<T> temp = this.first; temp != null; temp.getNext()) {
            arrayObjects[index++] = temp.getData();
        }
        return arrayObjects;
    }
    
    @SuppressWarnings("hiding")
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
    
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }


    /**
     * Inner class who defines 
     * the nodes in the list
     * 
     * @see DoiderasSinglyLinkedList
     * @see DoiderasList
     */
    @SuppressWarnings("hiding")
    private class DoiderasNode<T> {
        
        private T data;
        private DoiderasNode<T> nextNode;


        DoiderasNode(T data) {
            setData(data);
            setNext(null);
        }


        void setData(T data) {
            this.data = data;
        }
        
        T getData() {
            return this.data;
        }

        void setNext(DoiderasNode<T> next) {
            this.nextNode = next;
        }

        DoiderasNode<T> getNext() {
            return this.nextNode;
        }
    }
}