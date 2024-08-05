package statickeyword;

public class Main {

    public static void main(String[] args) {

        Utils a = new Utils();
        ChildUtils b = new ChildUtils();
        Utils c = new ChildUtils();

        c.fun();
        c.sfun();


    }
}
