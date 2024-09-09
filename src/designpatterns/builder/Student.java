package designpatterns.builder;

public class Student {
    private final String name;
    private final int age;
    private final String universityName;
    private final double psp;
    private final String phoneNo;

    public Student(StudentBuilder studentBuilder) {

        // Validations

        if (studentBuilder.getAge() == 0) {
            throw new IllegalArgumentException("Age not passed.");
        }

        if (!studentBuilder.getName().equals("test") && studentBuilder.getPsp() < 0) {
            throw new IllegalArgumentException("Negative psp only for test accounts");
        }


        this.name = studentBuilder.getName();
        this.age = studentBuilder.getAge();
        this.universityName = studentBuilder.getUniversityName();
        this.psp = studentBuilder.getPsp();
        this.phoneNo = studentBuilder.getPhoneNo();
    }

    public void enroll() {
        System.out.println("Enrolling the student with the following details " + this);
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", universityName='" + universityName + '\'' +
                ", psp=" + psp +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
