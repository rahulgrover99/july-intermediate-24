package statickeyword;

public class Utils {

    final static double PI = 3.14;

    int a = 5;


    void fun() {
        System.out.println(PI);
        System.out.println("Parent");

    }


    static void sfun() {
        System.out.println("Utils method");
        // because a is not static.
//        System.out.println(a);

    }

}
