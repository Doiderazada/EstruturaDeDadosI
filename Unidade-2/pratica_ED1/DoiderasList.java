package pratica_ED1;

import java.util.Collection;
import java.util.Iterator;


public interface DoiderasList<T> extends Collection<T>{

    
    public boolean addFirst(T element);

    public boolean addLast(T element);
    
    public void add(int index, T element);
    
    public boolean removeFirst();

    public boolean removeLast();
    
    public T remove(int index);
    
    public boolean addAll(int index, Collection<T> c); 
    
    public T get(int index);
    
    public T set(int index, T element); 

    public int indexBy(int index, T element);

    public int indexOf(T element);
    
    public int lastIndexOf(T element); 
    
    public DoiderasList<T> subList(int initIndex, int finalIndex);
}