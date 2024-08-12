package locks;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{

    Counter counter;
    Lock lock;

    public Adder(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hi hi no lock adder");
            lock.lock();
            System.out.println(i + " Adder thread incrementing the value: "+ counter.val);
            counter.val += i;
            lock.unlock();
            // We can pass the access to subtractor
            System.out.println("bye bye no lock adder");

        }
    }
}
