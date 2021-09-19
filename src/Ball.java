import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private final BallCanvas canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x;
    private int y;
    private int dx = 2;
    private int dy = 2;

    Color ballColor;

    public Ball(BallCanvas c, Color ballColor){
        this.canvas = c;
        this.ballColor = ballColor;


        if(Math.random()<0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public Ball(BallCanvas c, Color ballColor, int x, int y) {
        this.canvas = c;
        this.ballColor = ballColor;

        this.x = x;
        this.y = y;
    }

    public void draw (Graphics2D g2){
        g2.setColor(ballColor);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));
    }

    public void move(){
        x+=dx;
        y+=dy;
        if(x<0){
            x = 0;
            dx = -dx;
        }
        if(x+XSIZE>=this.canvas.getWidth()){
            x = this.canvas.getWidth()-XSIZE;
            dx = -dx;
        }
        if(y<0){
            y=0;
            dy = -dy;
        }
        if(y+YSIZE>=this.canvas.getHeight()){
            y = this.canvas.getHeight()-YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

    public boolean checkOverlap(){
        for (var pot : canvas.pots){
            if (this.x >= pot.getX()
                    && this.y >= pot.getY()
                    && this.x + XSIZE <= pot.getX() + Pot.SIZE
                    && this.y + YSIZE <= pot.getY() + Pot.SIZE){
                synchronized (canvas) {
                    canvas.removeBall(this);
                }
                pot.incrementsCounter();
                return true;
            }
        }
        return false;
    }
}
