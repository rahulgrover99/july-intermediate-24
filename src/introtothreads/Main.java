package introtothreads;

public class Main {
    public static void main(String[] args) {



        HelloWorld helloWorld = new HelloWorld();
        Thread t1 = new Thread(helloWorld, "HelloWorldThread");


        System.out.println("I am printing thread of main function: " + Thread.currentThread().getName());
        t1.start();


    }
}
