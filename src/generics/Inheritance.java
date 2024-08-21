package generics;

import inheritance.Instructor;
import inheritance.Learner;
import inheritance.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Function;

// Inheritance can be used for Learners
// for type Instructors, and Users
public class Inheritance <E extends User> {

    void addUsers(List<E> users) {
//            users.add(new Instructor("Raj", "12", "12", 9.0));
    }

    public static void main(String[] args) {

        Optional<Integer> x = Optional.of(1);

        if (x.isEmpty()) {
            System.out.println("x is empty");
        }

        Function<Integer, String> sc = new StringConverter();

        Optional<String> convertedInt = x.map(sc);

        System.out.println(convertedInt.get() + "1");


        Optional<Learner> learner = Optional.of(new Learner("Raj", "12", "12", 9.0));


        Function<Object, String> f = Object::toString;

        System.out.println(learner.map(f).orElse("No Name"));

    }





}
