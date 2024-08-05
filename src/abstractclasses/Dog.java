package abstractclasses;

public class Dog extends Animal{
    public Dog(int a) {
        super(a);
    }

    @Override
    void walk() {
        System.out.println("Dog is walking");
    }

    @Override
    void run() {
        super.run();
    }
}
