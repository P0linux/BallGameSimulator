package Task6;

public class SyncBlockCounter implements ICounter{
    private int counter;

    @Override
    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    @Override
    public void decrement() {
        synchronized (this) {
            counter--;
        }
    }

    @Override
    public void printOut() {
        System.out.println(counter);
    }
}
