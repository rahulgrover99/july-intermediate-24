package accessmodifier;

public class Main {
    public static void main(String[] args) {

        Student st = new Student();

        // psp is part of package accessmodifier
        st.psp = 90.0;

        st.age = 10;

//        st.name = "Rahul";

        st.display();

    }
}
