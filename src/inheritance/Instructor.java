package inheritance;

public class Instructor extends User{
    double avgRating;

    public Instructor(String name, String email, String password, double avgRating) {
        super("name", email, password);
        this.avgRating = avgRating;

    }

    void scheduleSession(String batch) {
        System.out.println("session scheduled for batch " + batch);
    }

}
