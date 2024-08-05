package abstractclasses;

public abstract class Animal {

    int a;

    public Animal(int a) {
        this.a = a;
    }

    abstract void walk();

    void run() {
        System.out.println("The animal runs" + a);
    }

}
