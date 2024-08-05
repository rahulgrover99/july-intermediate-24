package assigment;

public class Client {
    public static void main(String[] args) {

        accessmodifier.Student a = new accessmodifier.Student();
        a.age = 10;
//        a.psp = 20.0;
        a.display();


        // s1 = @752
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";

        // s2 = @753
        Student s2 = new Student();
        s2.age = 20;
        s2.name = "B";

        swap(s1, s2);

        // s1 = 752
        s1.display();
    }

    private static void swap(Student student1, Student student2) {
        // student1 = @752
        // student2 = @753


        Student temp = student1;
        student1 = student2;
        student2 = temp;

        student1.display();

        // student1 = @753
        // student2 = @752

    }
}