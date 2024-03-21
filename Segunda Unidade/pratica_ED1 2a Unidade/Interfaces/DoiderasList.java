package pratica_ED1.Interfaces;

import java.util.Collection;
import java.util.Iterator;


public interface DoiderasList<T> extends Collection<T>{


    public int size();

    public boolean isEmpty(); 
    
    public boolean contains(Object element);
    
    public boolean containsAll(Collection<?> c); 

    
    public boolean addFirst(T element);

    public boolean addLast(T element);

    public boolean add(T e);
    
    public void add(int index, T element);
    
    public boolean removeFirst();

    public boolean removeLast();

    public boolean remove(Object element);
    
    public T remove(int index);
    
    
    public boolean addAll(Collection<? extends T> c);
    
    public boolean addAll(int index, Collection<T> c); 
    
    public boolean removeAll(Collection<?> c);
    
    public boolean retainAll(Collection<?> c);
    

    public void clear();
    
    public T get(int index);
    
    public T set(int index, T element); 
    

    public int indexOf(Object element);
    
    public int lastIndexOf(Object element); 
    
    public DoiderasList<T> subList(int initIndex, int finalIndex);

    
    public T[] toArray();
    
    @SuppressWarnings("hiding")
    public <T> T[] toArray(T[] array);


    public Iterator<T> iterator();
}