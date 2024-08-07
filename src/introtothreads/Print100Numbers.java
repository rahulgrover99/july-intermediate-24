package introtothreads;

public class Print100Numbers {

    public static void main(String[] args) {


        // Order of printing will be nondeterministic.
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new NumberPrinter(i));
            t.start();
            t.run();
            // run()
        }

    }
}
