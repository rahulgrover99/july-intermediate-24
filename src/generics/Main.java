package generics;

import inheritance.Instructor;
import inheritance.User;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static <K, V> void doSomething(K key, V value) {
        System.out.println(key);
        System.out.println(value);
    }

    public static <X> X doSomething(){
        return (X) BigInteger.ONE;
    }

    // Instructor -> User
    // List<Instructor> -> List<User> -> Nope!

    public static <E extends User> void printUsers(List<E> users) {
        for (E user: users) {
            user.login();
            System.out.println(user);
        }
    }

    public static void main(String[] args) {

        // Raw use of parameterized types.
        Pair<Double, Double> pair = new Pair<>(1.0, 2.0);

        Pair student = new Pair("Student", 1.0);

        Double latitude = pair.getFirst();

        String name = (String) student.getFirst();

        System.out.println(latitude);


        doSomething("Rahul", 1);


        List<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor("Raj", "12", "12", 9.0));

        printUsers(instructors);


        User user = new Instructor("Raj", "12", "12", 9.0);


        List<Object> objects = new ArrayList<>();
        objects.add(new Object());


//        printUsers(objects) -> not allowed


    }
}
