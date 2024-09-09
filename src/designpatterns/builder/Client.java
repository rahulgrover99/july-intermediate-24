package designpatterns.builder;

public class Client {


    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setAge(12);
        studentBuilder.setName("test");
        studentBuilder.setPhoneNo("9814311067");
        studentBuilder.setPsp(-1);

        Student student = new Student(studentBuilder);
        student.enroll();

    }
}
