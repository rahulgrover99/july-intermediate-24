package collections;


public class LinkedListNode<E> implements Comparable<LinkedListNode<E>>{
    E data;
    LinkedListNode<E> next;

    public LinkedListNode(E data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(LinkedListNode<E> o) {
        return this.hashCode() - o.hashCode();
    }
}
