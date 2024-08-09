package polymorphism;



public class Main {

    public static void main(String[] args) {

        Instructor instructor = new Instructor();
        instructor.login();
        System.out.printf("%d, %d, %d", instructor.val, instructor.val1, instructor.val2);

        User user = new User();
        user.login();
        System.out.printf("%d, %d", user.val, user.val2);

        User ic = new Instructor();
        ic.login();
        System.out.printf("%d, %d", ic.val, ic.val2);

    }

}
