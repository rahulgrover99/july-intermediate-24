package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Lock lock = new ReentrantLock();
        Thread adder = new Thread(new Adder(counter, lock));

        Thread subtractor = new Thread(new Subtractor(counter, lock));

        adder.start();
        subtractor.start();

        adder.join();
        subtractor.join();

        System.out.println(counter.val);

    }

}
