package Task6;

public class SyncMethodCounter implements ICounter{
    private int counter;

    @Override
    public synchronized void increment() {
        counter++;
    }

    @Override
    public synchronized void decrement() {
        counter--;
    }

    @Override
    public void printOut() {
        System.out.println(counter);
    }
}
