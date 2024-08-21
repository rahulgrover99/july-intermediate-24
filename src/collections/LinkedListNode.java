package collections;

public class LinkedListNode<E> {
    E data;
    LinkedListNode<E> next;

    public LinkedListNode(E data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }
}
