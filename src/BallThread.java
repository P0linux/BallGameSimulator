public class BallThread extends Thread {
    private Ball b;
    private Thread thread;

    public BallThread(Ball ball, int priority){
        b = ball;
        this.setPriority(priority);
    }

    public BallThread(Ball ball, Thread thread){
        b = ball;
        this.thread = thread;
    }

    @Override
    public void run(){
        try{
            if (thread != null) thread.join();
            for(int i=1; i<10000; i++){
                b.move();
                if (b.checkOverlap()) return;
                Thread.sleep(5);
            }
        } catch(InterruptedException ignored){

        }
    }
}
