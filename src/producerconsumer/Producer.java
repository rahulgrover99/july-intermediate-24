package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    Queue<Object> sharedBuffer;
    int capacity;

    Semaphore ps;
    Semaphore cs;

    public Producer(Queue<Object> sharedBuffer, int capacity, Semaphore ps, Semaphore cs) {
        this.sharedBuffer = sharedBuffer;
        this.capacity = capacity;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {
        // Before running make sure there is demand of atleast 1 producer to run
        try {
            ps.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // Waiting for it to be less than capacity.
//        while (sharedBuffer.size() >= capacity) {
//        }
//        System.out.println("Size in Producer before adding: " + sharedBuffer.size());
        sharedBuffer.add(new Object());
        cs.release();

    }
}
