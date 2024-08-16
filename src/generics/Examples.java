package generics;

import inheritance.Instructor;
import inheritance.Learner;

import java.util.ArrayList;
import java.util.List;

public class Examples {
    public static void main(String[] args) {

        Inheritance<Learner> instructorInheritance = new Inheritance<>();
        List<Learner> learners = new ArrayList<>();
        learners.add(new Learner("Raj", "12", "12", 9.0));
        instructorInheritance.addUsers(learners);
//        learners.add(new Instructor("Raj", "12", "12", 9.0));

        for (Learner learner: learners) {
            learner.attemptContest();
        }


        System.out.println(learners);

    }

}
