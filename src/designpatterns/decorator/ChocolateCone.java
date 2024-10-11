package designpatterns.decorator;


public class ChocolateCone implements IceCream{
    @Override
    public String getDesc() {
        return "Chocolate Cone";
    }

    @Override
    public int getCost() {
        return 20;
    }

}
