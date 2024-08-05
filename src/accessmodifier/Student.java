package accessmodifier;

public class Student {

    public int age;

    // default access modifier is package - private.
    double psp;
    private String name;

    public void display() {
        System.out.println("My name is " + this.name + " " + this.psp + " " + this.age);
    }


}
