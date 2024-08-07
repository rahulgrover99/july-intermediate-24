package introtothreads;

public class HelloWorld implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World!");
        System.out.println(Thread.currentThread().getName());

        Thread thread = Thread.currentThread();
        System.out.println(thread);

    }

}
