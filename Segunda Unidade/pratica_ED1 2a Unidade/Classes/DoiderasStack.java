package pratica_ED1.Classes;

import java.util.Vector;

public class DoiderasStack<T> extends Vector<T> {
    
    public DoiderasStack() {}



    public T push(T element) {
        addElement(element);
        return element;
    }

    public T pop() {
        T element = peek();
        removeElementAt(size() - 1);
        return element;
    }

    public T peek() {
        T element = get(size() - 1);
        return element;
    }

    public boolean empty() {
        return isEmpty();
    }

    public int search(T element) {
        int i = lastIndexOf(element, 0);
        if (i >= 0) return (size() - i);

        return i;
    }
}
