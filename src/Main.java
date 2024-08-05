public class Main {
    // Special method that's the entry point for Java compiler
    public static void main(String[] args) {
        // Prints on terminal.
        System.out.println("Hello world!");

        // Object created.
        Student divya = new Student();
        Student pranav = new Student();

        divya.psp = 80.0;
        divya.name = "Divya";
        divya.emailAddress = "divya@gmail.com";

        pranav.name = "Pranav";
        pranav.psp = 90.0;

        divya.scheduleTaSession(30);


        pranav.scheduleTaSession(20);

    }
}