package Task6;

public class Counter implements ICounter{
    private int counter;

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public void decrement() {
        counter--;
    }

    @Override
    public void printOut() {
        System.out.println(counter);
    }
}
