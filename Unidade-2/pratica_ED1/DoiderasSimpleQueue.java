package pratica_ED1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import pratica_ED1.DoiderasQueue;

public class DoiderasSimpleQueue<T> implements DoiderasQueue<T>{
    
    
    private T[] queue;
    private int size;
    private int first;
    private int last;

    private final int minimalGrowth = 10;
    private final int minimalCapacity = 5;


    @SuppressWarnings("unchecked")
    DoiderasSimpleQueue() {
        queue = (T[]) new Object[minimalCapacity];
        this.size = 0;
        this.last = this.first = -1;
    }
    
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        if (size() > 0) return false;
        return true;
    }

    public void grow() {
        int newCapacity = this.size + minimalGrowth;

        this.queue = Arrays.copyOf(queue, newCapacity);
    }
    
    public void grow(int newCapacity) {
        this.queue = Arrays.copyOf(queue, newCapacity);
    }
    


    @Override
    public boolean add(Object element) {
        return offer(element);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean offer(Object element) {
        if (element == null) return false;

        if (this.last == (queue.length-1)) {
            grow(size() + 3);
            this.size = queue.length;
        }
        
        queue[last+1] = (T) element;
        this.last++;
        if (isEmpty()) this.first++;
        this.size++;
        System.out.println(queue[last]);

        return true;
    }
    
    @Override
    public Object remove() {
        return poll();
    }
    
    @Override
    public boolean remove(Object element) {
        for (int i = 0; i <= last; i++) {
            if(queue[i].equals(element)) {
                for (int j = i; j < last; j++) {
                    queue[j] = queue[j+1];
                }
                this.last--;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Object poll() {
        T elementRemoved = queue[first];
        for (int i = 0; i < size()-1; i++)
            queue[i] = queue[i+1];
        queue[last] = null;
        this.last--;
        return elementRemoved;
    }
    
    @Override
    public Object element() {
        return peek();
    }
    
    @Override
    public Object peek() {
        return queue[first];
    }



    @Override
    public boolean contains(Object element) {
        for (int i = 0; i <= last; i++) {
            if (queue[i].equals(element)) 
                return true;
        }
        return false;
    }

    @Override
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
    


    @Override
    public boolean addAll(Collection<? extends T> c) {
        @SuppressWarnings("unchecked")
        T[] arrayTs = (T[]) c.toArray();
        int length = arrayTs.length;
        int index = 0;
        boolean added;
        do {
            added = offer(arrayTs[index++]);
            if (index == length) break;
        } while (added);
        return added;
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        @SuppressWarnings("unchecked")
        T[] arrayTs = (T[]) c.toArray();
        int length = arrayTs.length;
        int index = 0;
        boolean removed;
        do {
            removed = remove(arrayTs[index++]);
            if (index == length) break;
        } while (removed);
        return removed;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(Collection<?> c) {
        if (containsAll(c)) {
            clear();
            return addAll((Collection<? extends T>) c);
        }
        return false;
    }



    @Override
    public void clear() {
        for (int i = 0; i <= last; i++) {
            queue[i] = null;
        }
        this.size = 0;
        this.last = this.first = -1;
    }




    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] arrayFinal = (T[]) new Object[size()];
        for (int i = 0; i < arrayFinal.length; i++) {
            arrayFinal[i] = queue[i];
        }
        return arrayFinal;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }



    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }


    public String show() {
        String output = "[";
        for (int i = 0; i < size(); i++) {
            output = output + this.queue[i] + ", "; 
        }
        int index = output.lastIndexOf(",");
        output = output.substring(0, index);
        output+= "]";
        return output;
    }
}