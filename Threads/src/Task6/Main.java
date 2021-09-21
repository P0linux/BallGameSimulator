package Task6;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ICounter counter = new Counter();
        ICounter counter1 = new SyncObjectCounter();
        ICounter counter2 = new SyncBlockCounter();
        ICounter counter3 = new SyncMethodCounter();

        Thread incThread = new CounterIncrementThread(counter);
        Thread decThread = new CounterDecrementThread(counter);

        Thread incThread1 = new CounterIncrementThread(counter1);
        Thread decThread1 = new CounterDecrementThread(counter1);

        Thread incThread2 = new CounterIncrementThread(counter2);
        Thread decThread2 = new CounterDecrementThread(counter2);

        Thread incThread3 = new CounterIncrementThread(counter3);
        Thread decThread3 = new CounterDecrementThread(counter3);

        incThread.start();
        decThread.start();

        incThread1.start();
        decThread1.start();

        incThread2.start();
        decThread2.start();

        incThread3.start();
        decThread3.start();

        incThread.join();
        decThread.join();

        incThread1.join();
        decThread1.join();

        incThread2.join();
        decThread2.join();

        incThread3.join();
        decThread3.join();

        counter.printOut();
        counter1.printOut();
        counter2.printOut();
        counter3.printOut();
    }
}
