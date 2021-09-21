package Task5;

public class Main {
    public static void main(String[] args){
        SymbolThread firstThread = new SymbolThread('-');
        SymbolThread secondThread = new SymbolThread('|');

        //firstThread.start();
        //secondThread.start();

        Semaphore firstSemaphore = new Semaphore(1);
        Semaphore secondSemaphore = new Semaphore(0);

        SymbolThreadSynchronized firstThreadSync = new SymbolThreadSynchronized('-', firstSemaphore, secondSemaphore, false);
        SymbolThreadSynchronized secondThreadSync = new SymbolThreadSynchronized('|', secondSemaphore, firstSemaphore, true);

        firstThreadSync.start();
        secondThreadSync.start();
    }
}
