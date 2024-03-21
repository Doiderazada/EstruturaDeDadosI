package pratica_ED1;

import pratica_ED1.DoiderasSinglyLinkedList;

public class Teste {
    public static void main(String[] args) {
        DoiderasSinglyLinkedList<Integer> listinha = new DoiderasSinglyLinkedList<Integer>();

        listinha.addFirst(15);
        listinha.add(10);
        listinha.addLast(20);
        listinha.addFirst(100);

        for(int i = 0; i < listinha.size(); i++){ System.out.println(listinha.get(i));};
    }
}
