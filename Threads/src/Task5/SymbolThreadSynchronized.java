package Task5;

public class SymbolThreadSynchronized extends Thread {

    private final char symbol;
    private static final int symbolCount = 50;
    private final Semaphore semaphore1;
    private final Semaphore semaphore2;
    private final boolean printBreak;

    public SymbolThreadSynchronized(char symbol, Semaphore semaphore1, Semaphore semaphore2, boolean printBreak){
        this.symbol = symbol;
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.printBreak = printBreak;
    }

    @Override
    public void run(){
        for (int i = 0; i < 50; i++){
            for (int j = 0; j < symbolCount; j++){
                semaphore1.lease();
                System.out.print(symbol);
                if (printBreak && j == symbolCount - 1){
                    System.out.println();
                }
                semaphore2.release();
            }
        }
    }
}
