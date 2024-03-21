package pratica_ED1;

import pratica_ED1.Classes.DoiderasSinglyLinkedList;

public class PilhaComLista<T> {
    
    private int head;
    private DoiderasSinglyLinkedList<T> stack;


    public PilhaComLista() {
        head = -1;
        stack = new DoiderasSinglyLinkedList<T>();
    }

    public T push(T element) {
        if (empty()) stack.addFirst(element);
        else stack.addLast(element);
        head++;
        return element;
    }

    public T pop() {
        if (empty()) return null;
        else {
            T element = peek();
            stack.removeLast();
            head--;
            return element;
        }
    }

    public T peek() {
        return stack.get(head);
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public int search(T element) {
        int index = stack.lastIndexOf(element);
        if (index >= 0) return (stack.size() - index);
        return index;
    }
}
