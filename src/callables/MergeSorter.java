package callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    List<Integer> array;
    ExecutorService executorService;

    public MergeSorter(List<Integer> array, ExecutorService executorService) {
        this.array = array;
        this.executorService = executorService;
    }

    // Returns the sorted list back.
    public List<Integer> sort() throws ExecutionException, InterruptedException {
        // 1. Split the array into 2 parts.
        // 2. Sort the arrays individually
        // 3. Merge the 2 sorted arrays.

        System.out.println("Sorting array: " + array + " from thread " + Thread.currentThread().getName());


        if (array.size() <= 1) {
            return array;
        }

        // Step 1.
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int mid = array.size() / 2;

        for (int i = 0; i < mid; i++) left.add(array.get(i));
        for (int i = mid; i < array.size(); i++) right.add(array.get(i));


        // Step 2. -> Sorting on separate threads.
        Future<List<Integer>> leftSortedFuture = executorService.submit(new MergeSorter(left, executorService));
        Future<List<Integer>> rightSortedFuture = executorService.submit(new MergeSorter(right, executorService));


        List<Integer> sortedLeft = leftSortedFuture.get();
        List<Integer> sortedRight = rightSortedFuture.get();

        // Step 3.
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < sortedLeft.size() && j < sortedRight.size()) {
            if (sortedLeft.get(i) < sortedRight.get(j)) {
                result.add(sortedLeft.get(i));
                i++;
            } else {
                result.add(sortedRight.get(j));
                j++;
            }
        }

        while (i < sortedLeft.size()){
            result.add(sortedLeft.get(i));
            i++;
        }

        while(j < sortedRight.size()) {
            result.add(sortedRight.get(j));
            j++;
        }

        System.out.println("Sorted array: " + result + " from thread " + Thread.currentThread().getName());

        return result;

    }

    @Override
    public List<Integer> call() throws Exception {
        return sort();
    }
}
