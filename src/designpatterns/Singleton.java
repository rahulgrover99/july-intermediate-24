package designpatterns;

public class Singleton {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        Logger logger2 = Logger.getInstance();
        logger2.log("Hi");
    }

}
