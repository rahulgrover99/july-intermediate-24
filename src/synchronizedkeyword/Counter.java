package synchronizedkeyword;


public class Counter {
    private int val = 0;

    // Object level lock on the Counter object calling it.
    public synchronized void increment(int i) {
            val += i;
    }

    public int getVal() {
        return val;
    }
}
