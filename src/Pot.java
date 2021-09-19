import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pot {

    public static final int SIZE = 40;
    private int ballCounter = 0;

    private JLabel counterLabel;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int y;

    public Pot(int x, int y, JLabel label) {
        this.x = x;
        this.y = y;
        counterLabel = label;
    }

    public synchronized void incrementsCounter(){
        ballCounter++;
        setTextField();
    }

    private void setTextField(){
        counterLabel.setText(String.valueOf(ballCounter));
    }

    public void draw (Graphics2D g2){
        g2.setColor(Color.pink);
        g2.setStroke(new BasicStroke(3));
        g2.draw(new Ellipse2D.Double(x, y, SIZE, SIZE));
    }
}
