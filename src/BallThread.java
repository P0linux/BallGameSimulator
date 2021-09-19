public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball, int priority){
        b = ball;
        this.setPriority(priority);
    }
    @Override
    public void run(){
        try{
            for(int i=1; i<10000; i++){
                b.move();
                if (b.checkOverlap()) return;
                Thread.sleep(5);
            }
        } catch(InterruptedException ignored){

        }
    }
}
