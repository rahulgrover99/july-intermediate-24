package synchronizedkeyword;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread adder = new Thread(new Adder(counter));

        Thread subtractor = new Thread(new Subtractor(counter));

        adder.start();
        subtractor.start();

        adder.join();
        subtractor.join();

        System.out.println(counter.getVal());

    }

}

class Compare implements Comparator<Integer> {

    @Override
    public int compare(Integer integer, Integer t1) {
        return 0;
    }
}