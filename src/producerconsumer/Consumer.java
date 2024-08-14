package producerconsumer;

import java.util.Hashtable;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable{

    Queue<Object> sharedBuffer;
    Semaphore ps;
    Semaphore cs;


    public Consumer(Queue<Object> sharedBuffer, Semaphore ps, Semaphore cs) {
        this.sharedBuffer = sharedBuffer;
        this.ps = ps;
        this.cs = cs;
    }

    @Override
    public void run() {
        try {
            cs.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // Busy waiting -> for shared buffer to have something.
        while (sharedBuffer.isEmpty()) continue;
        System.out.println("Size in Consumer before removing: " + sharedBuffer.size());
        if (!sharedBuffer.isEmpty()) {

            sharedBuffer.remove();
        }
        ps.release();
    }
}
