package Task5;

import java.util.concurrent.atomic.AtomicInteger;

public class Semaphore {
    private AtomicInteger counter;

    public Semaphore(int firstCount) {
        counter = new AtomicInteger(firstCount);
    }

    public void lease() {
        while (true) {
            if (counter.get() <= 0) continue;
            else counter.decrementAndGet();
            break;
        }
    }

    public void release() {
        counter.incrementAndGet();
    }
}
