package inheritance;

public class Main {
    public static void main(String[] args) {

        Instructor instructor = new Instructor("rahul", "xyz", "sas", 4.9);
//        instructor.name = "Rahul";
//        instructor.avgRating = 4.9;
//        instructor.email = "rahul.grover_1@scaler.com";



        Learner learner = new Learner("Sai", "abc", "mno", 90);
//        learner.name = "Sai";
//        learner.email = "sai@gmail.com";
//        learner.psp = 90.0;

        instructor.login();
        learner.login();

//        User user = new User();


        instructor.scheduleSession("Int May");
        learner.attemptContest();



    }
}
