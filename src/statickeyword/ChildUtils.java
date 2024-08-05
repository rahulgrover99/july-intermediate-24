package statickeyword;

public class ChildUtils extends Utils{

    void fun() {
        System.out.println(PI);
        System.out.println("Child Method");
    }



    static void sfun() {
        System.out.println("Child method");
        // because a is not static.
//        System.out.println(a);

    }

}
