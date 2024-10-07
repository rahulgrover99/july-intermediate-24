import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    // Special method that's the entry point for Java compiler
    public static void main(String[] args) {
        // Prints on terminal.
        AtomicInteger sum= new AtomicInteger();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> sum.addAndGet(n));
        System.out.println(sum.get());

    }
}