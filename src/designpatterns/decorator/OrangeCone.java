package designpatterns.decorator;

public class OrangeCone implements IceCream{

    public OrangeCone(IceCream iceCream) {

        this.iceCream = iceCream;
    }

    public OrangeCone() {
        iceCream = null;
    }

    private IceCream iceCream;

    @Override
    public String getDesc() {
        String prefix = (iceCream == null) ? "" : iceCream.getDesc() + " + ";
        return prefix + "Orange Cone";
    }

    @Override
    public int getCost() {
        int previousCost = (iceCream == null) ? 0 : iceCream.getCost();
        return previousCost + 10;
    }
}
