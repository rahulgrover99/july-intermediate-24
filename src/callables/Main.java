package callables;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        List<Integer> list = List.of(5, 7, 1, 4, 3, 2, 6, 10);

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        MergeSorter mergeSorter = new MergeSorter(list, executorService);


        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);


        System.out.println("Hello World");

        // Waiting for the future to complete.
        System.out.println(sortedListFuture.get());

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println(timeElapsed);

        executorService.shutdown();
    }


}
