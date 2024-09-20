package designpatterns.decorator;

public class VanillaScoop implements IceCream{
    private final IceCream iceCream;

    public VanillaScoop(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDesc() {
        return iceCream.getDesc() + "+ Vanilla scoop";
    }

    @Override
    public int getCost() {
        return iceCream.getCost() + 45;
    }
}
