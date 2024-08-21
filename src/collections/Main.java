package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(4, 5, 6));

        for (Integer integer : list) {
            System.out.println(integer);
        }


        LinkedListNode<Integer> n3 = new LinkedListNode<>(3, null);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(2, n3);
        LinkedListNode<Integer> n1 = new LinkedListNode<>(1, n2);

        LinkedList<Integer> linkedList = new LinkedList<>(n1);


        Iterator<Integer> itr2 = linkedList.iterator();

        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

        for (Integer i: linkedList) {
            System.out.println(i);
        }



        linkedList.printAll();

    }
}
