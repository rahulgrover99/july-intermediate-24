// Blueprint for a Student entity.
// Public is an access modifier which allows access to the class
// from anywhere in the codebase.
public class Student {

    // Attributes
    String name;
    String emailAddress;
    double psp;

    // Behaviours
    void scheduleTaSession(int duration){
        System.out.println(name + " scheduled a TA session for " + duration);
    }


}
