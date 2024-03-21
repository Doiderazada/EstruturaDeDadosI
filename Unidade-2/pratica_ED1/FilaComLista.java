package pratica_ED1;

import pratica_ED1.DoiderasSinglyLinkedList;

public class FilaComLista<T> {
    
    private DoiderasSinglyLinkedList<T> queue;
    private int first;
    private int last;

    FilaComLista() {
        this.last = this.first = -1;
        queue = new DoiderasSinglyLinkedList<>();
    }
    
    public boolean add(Object element) {
        return offer(element);
    }
    
    
    @SuppressWarnings("unchecked")
    public boolean offer(Object element) {
        first = 0;
        last++;
        return queue.addLast((T) element);
    }
    
    
    public Object remove() {
        return poll();
    }
    

    public Object poll() {
        if (queue.isEmpty()) return null;
        T removedElement = queue.get(first);
        queue.removeFirst();
        if (queue.isEmpty()) first = -1;
        last--;
        return removedElement;
    }
    
    
    public Object element() {
        return peek();
    }
    
    
    public Object peek() {
        if (queue.isEmpty()) return null;
        return queue.get(first);
    }
}