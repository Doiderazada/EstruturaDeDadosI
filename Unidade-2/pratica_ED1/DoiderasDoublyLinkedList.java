package pratica_ED1;

import java.util.Collection;
import java.util.Iterator;

import pratica_ED1.DoiderasList;

public class DoiderasDoublyLinkedList<T> implements DoiderasList<T> {

    private int size;
    private DoiderasNode<T> first;
    private DoiderasNode<T> last;



    
    public DoiderasDoublyLinkedList() {
        this.size = 0;
        this.last = this.first = null;
    }




    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (size() == 0) return true;
        return false;
    }



    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    public boolean containsAll(Collection<?> c) {
        @SuppressWarnings("unchecked")
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
            this.first = novo;
            this.last = this.first;
            this.size = size()+1;
            return;
        }
        if (index > size() | index < 0) return;
        if (index == size()-1) {
            addLast(element);
            return;
        }

        DoiderasNode<T> temp = this.first;
        for (int i = 0; i < index; i++) temp = temp.getNext();

        DoiderasNode<T> next = temp.getNext();
        temp.setNext(novo);
        novo.setPrev(temp);
        novo.setNext(next);
        next.setPrev(novo);
        this.size = size() + 1;
    }
    
    public boolean addAll(Collection<? extends T> c) {
        @SuppressWarnings("unchecked")
        T[] arrayTs = (T[]) c.toArray();
        int length = arrayTs.length;
        int index = 0;
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
            nodesToAdd[i+1].setPrev(nodesToAdd[i]);
        };

        DoiderasNode<T> next = temp.getNext();
        temp.setNext(nodesToAdd[0]);
        nodesToAdd[0].setPrev(temp);
        nodesToAdd[length-1].setNext(next);
        this.size = size() + length;
        return true;
    }




    public boolean removeFirst() {
        if (isEmpty()) return false;
        DoiderasNode<T> second = this.first.getNext();
        this.first.setNext(null);
        second.setPrev(null);
        this.first = second;
        this.size = size()-1;
        return true;
    }
    
    public boolean removeLast() {
        if (isEmpty()) return false;
        DoiderasNode<T> temp = this.first;
        for (int i = 0; i < size()-1; i++) temp = temp.getNext();
        
        temp.getPrev().setNext(null);
        this.last = temp.getPrev();
        this.size = size()-1;
        return true;
    }

    public boolean remove(Object element) {
        if (isEmpty()) return false;
        DoiderasNode<T> temp = this.first;
        int index = 0;

        if (contains(element)) index = lastIndexOf(element);
        if (index == -1) return false;
        
        if (size() == 1) {
            clear();
            return true;
        }
        
        if (index == 0) return removeFirst();
        if (index == (size()-1)) return removeLast();

        temp = this.first;
        for (int i = 0; i < index; i++) temp = temp.getNext();

        temp.getPrev().setNext(temp.getNext());
        temp.setNext(null);
        this.size = size()-1;
        return true;
    }
    
    public T remove(int index) {
        if (isEmpty()) return null;
        DoiderasNode<T> temp = this.first;
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
        
        for (int i = 0; i < index; i++) temp = temp.getNext();

        dataToReturn = temp.getData();
        temp.getPrev().setNext(temp.getNext());
        temp.setNext(null);
        this.size = size()-1;
        return dataToReturn;
    }
    
    public boolean removeAll(Collection<?> c) {
        if (isEmpty()) return false;

        @SuppressWarnings("unchecked")
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
        this.first = this.last = null;
        this.size = 0;
    }
    
    public T get(int index) {
        DoiderasNode<T> temp = this.first;
        
        for (int i = 0; i < index; i++) temp = temp.getNext();
        return temp.getData();
    }
    
    public T set(int index, T element) {
        DoiderasNode<T> temp = this.first;
        
        for (int i = 0; i < index; i++) temp = temp.getNext();
        T dataReplaced = temp.getData();
        temp.setData(element);
        return dataReplaced;
    }
    
    public int indexBy(int index, T element) {
        if (isEmpty()) return -1;
        DoiderasNode<T> temp = this.first;

        for (int i = 0; i <= index; i++) temp = temp.getNext();
        index++;
        
        while (temp != null) {
            if (temp.getData().equals(element)) return index; 
            temp = temp.getNext();      index++;
        } 
        return -1;
    }

    public int indexOf(T element) {
        if (isEmpty()) return -1;
        DoiderasNode<T> temp = this.first;
        int index = 0;
        
        do{    
            if (temp.getData().equals(element)) return index;
            index++;
            temp = temp.getNext();
        } while (temp != null);
        return -1;
    }
    
    public int lastIndexOf(T element) {
        if (isEmpty()) return -1;
        
        int temporaryIndex;

        int index = indexOf(element);
        if (index == -1) return index;
        
        do {
            temporaryIndex = indexBy(index, element);
            if (temporaryIndex == -1) break;
            index = temporaryIndex;
        } while (index != -1);
        return index;
    }
    
    public DoiderasList<T> subList(int initIndex, int finalIndex) {
        DoiderasList<T> novaLista = new DoiderasDoublyLinkedList<T>();
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
    

    
    public T[] toArray() {
        int index = 0;
        int length = size();
        @SuppressWarnings("unchecked")
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
    protected class DoiderasNode<T> {
        
        private T data;
        private DoiderasNode<T> nextNode;
        private DoiderasNode<T> prevNode;


        DoiderasNode(T data) {
            setData(data);
            setPrev(null);
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
        
        void setPrev(DoiderasNode<T> prev) {
            this.prevNode = prev;
        }

        DoiderasNode<T> getPrev() {
            return this.prevNode;
        }
    }
}
