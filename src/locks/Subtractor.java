package locks;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{

    Counter counter;
    Lock lock;

    public Subtractor(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            System.out.println(i + " Subtractor thread decrementing the value: "+ counter.val);
            counter.val -= i;
            lock.unlock();
        }
    }
}
