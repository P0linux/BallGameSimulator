package Task6;

public class SyncObjectCounter implements ICounter{
    private int counter;
    private final Object lock = new Object();

    @Override
    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    @Override
    public void decrement() {
        synchronized (lock) {
            counter--;
        }
    }

    @Override
    public void printOut() {
        System.out.println(counter);
    }
}
