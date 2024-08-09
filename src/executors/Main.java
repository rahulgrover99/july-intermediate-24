package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            NumberPrinter numberPrinter = new NumberPrinter(i);
//            numberPrinter.run();

            executorService.submit(numberPrinter);
        }

        executorService.shutdown();

    }

}
