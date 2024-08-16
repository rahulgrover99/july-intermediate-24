package inheritance;

public class Learner extends User{

    double psp;

    public Learner(String name, String email, String password, double psp) {
        super(name, email, password);
        this.psp = psp;
    }

    public void attemptContest() {
        System.out.println(name + " attempted a contest. ");
    }

}
