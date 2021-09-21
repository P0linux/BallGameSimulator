package Task6;

public class CounterDecrementThread extends Thread{
    private ICounter counter;

    public CounterDecrementThread(ICounter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100000; i++){
            counter.decrement();
        }
    }
}
