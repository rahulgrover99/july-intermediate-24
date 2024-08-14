package producerconsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Showroom - shared buffer.
        // Producers add pbjects
        // Consumers remove objects
        Queue<Object> queue = new ConcurrentLinkedQueue<>();

        // In the beginning since the capacity is 5 -> allow 5 producers to run
        Semaphore ps = new Semaphore(5);
        // Since 0 objects dont allow consumers to run.
        Semaphore cs = new Semaphore(0);

        for (int i = 0; i < 1000; i++) {
            Producer producer = new Producer(queue, 5, ps, cs);
            Consumer consumer = new Consumer(queue, ps, cs);

            Thread p = new Thread(producer);
            p.start();

            Thread c = new Thread(consumer);
            c.start();

        }

        Thread.sleep(1000);

        System.out.println(queue.size());




    }



}
