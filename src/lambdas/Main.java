package lambdas;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
                System.out.println(this.getClass().getName());
            }
        });

        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
                System.out.println(this.getClass().getName());
            }
        });


        thread2.start();

        Thread thread3 = new Thread(()  -> printStuff());


        Optional<Integer> optionalInteger = Optional.of(1);
        Function<Integer, Integer> mapper = x -> x + 2;
        optionalInteger.map(x -> String.valueOf(x + 2));


        MyInterface obj = new MyInterface() {
            @Override
            public void fun1() {
                System.out.println("My anonymous class function");
            }
        };

        foobar(obj);

        foobar(() -> System.out.println("Printing from lambda"));

        abstractClass(new MyAbstractClass() {
            @Override
            void fun1() {
                System.out.println("Hello");
            }
        });


        Callable<Integer> callable = () -> {
            System.out.println("Hello byeee");
            return 5;
        };

        Future<Integer> integerFuture = Executors.newSingleThreadExecutor().submit(callable);
        System.out.println(integerFuture.get());


        int a = 5, b = 6;

        MyInterfaceWithParams myInterfaceWithParams = (x, y) -> {
            return x + y;
        };

        System.out.println(myInterfaceWithParams.sum(5, 6));


        Function<String, String> printer = txt -> {
            System.out.println("Printing" + txt);
            return txt;
        };

        execute("heheheh" , printer);
    }

    static String execute(String inp, Function<String, String> function) {
        return function.apply(inp);
    }

    static void printStuff() {
        System.out.println("Printing bleh");
        System.out.println("hahahahahah");
    }

    static void foobar(MyInterface obj) {
        obj.fun1();
        System.out.println(obj.getClass().getName());
    }


    static void abstractClass(MyAbstractClass obj) {
        obj.fun1();
    }




}
