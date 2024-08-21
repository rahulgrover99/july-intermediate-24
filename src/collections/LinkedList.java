package collections;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    LinkedListNode<E> head;

    public LinkedList(LinkedListNode<E> head) {
        this.head = head;
    }

    void printAll() {
        LinkedListNode<E> curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(head);
    }

    class LinkedListIterator<E> implements Iterator<E> {

        private LinkedListNode<E> curr;

        public LinkedListIterator(LinkedListNode<E> curr) {
            this.curr = curr;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public E next() {
            E data = curr.data;
            curr = curr.next;
            return data;
        }
    }

}
