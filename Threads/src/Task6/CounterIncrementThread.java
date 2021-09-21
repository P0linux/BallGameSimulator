package Task6;

public class CounterIncrementThread extends Thread{

    private ICounter counter;

    public CounterIncrementThread(ICounter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100000; i++){
            counter.increment();
        }
    }
}
