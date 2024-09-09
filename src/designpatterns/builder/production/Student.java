package designpatterns.builder.production;

public class Student {
    private final String name;
    private final int age;
    private final String universityName;
    private final double psp;
    private final String phoneNo;

    // newBuilder
    // getBuilder
    // toBuilder
    // builder()
    public static StudentBuilder getBuilder() {
        return new StudentBuilder();
    }

    private Student(StudentBuilder studentBuilder) {

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

    public static class StudentBuilder {
        private String name;
        private int age;
        private String universityName;
        private double psp;
        private String phoneNo;

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public StudentBuilder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public StudentBuilder setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
