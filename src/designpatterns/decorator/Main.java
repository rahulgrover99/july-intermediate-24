package designpatterns.decorator;

public class Main {
    public static void main(String[] args) {

        IceCream iceCream =
                new OrangeCone(
                new VanillaScoop(
                        new ChocolateCone()));

        System.out.println(iceCream.getDesc());

    }
}
