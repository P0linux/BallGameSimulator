import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 750;
    public static final int HEIGHT = 750;

    private ArrayList<JLabel> potLabels = new ArrayList<>();

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();

        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");
        JButton buttonRedBall = new JButton("Create red ball");
        JButton buttonBlueBall = new JButton("Create blue ball");
        JButton buttonBlueRedBalls = new JButton("Red/Blue balls experiment");
        JButton buttonJoin = new JButton("Join experiment");

        buttonRedBall.addActionListener(e -> {
            Ball b = new Ball(canvas, Color.RED);
            canvas.addBall(b);

            BallThread thread = new BallThread(b, Thread.MAX_PRIORITY);
            thread.start();
            System.out.println("Thread name = " +
                    thread.getName());
        });

        buttonBlueBall.addActionListener(e -> {
            Ball b = new Ball(canvas, Color.BLUE);
            canvas.addBall(b);

            BallThread thread = new BallThread(b, Thread.MIN_PRIORITY);
            thread.start();
            System.out.println("Thread name = " +
                    thread.getName());
        });

        buttonStart.addActionListener(e -> {
            Ball b = new Ball(canvas, Color.BLACK);
            canvas.addBall(b);

            BallThread thread = new BallThread(b, Thread.NORM_PRIORITY);
            thread.start();
            System.out.println("Thread name = " +
                    thread.getName());
        });

        buttonBlueRedBalls.addActionListener(e -> {
            Ball rb = new Ball(canvas, Color.RED, 200, 200);

            ArrayList<Thread> threads = new ArrayList<>();
            for (int i = 0; i < 1000; i ++){
                Ball bb = new Ball(canvas, Color.BLUE, 200 ,200);
                canvas.addBall(bb);
                threads.add(new BallThread(bb, Thread.MIN_PRIORITY));
            }

            canvas.addBall(rb);
            for (Thread thread : threads){
                thread.start();
            }

            new BallThread(rb, Thread.MAX_PRIORITY).start();
        });

        buttonJoin.addActionListener(e -> {
            Ball firstBall = new Ball(canvas, Color.MAGENTA, 50, 50);
            Ball secondBall = new Ball(canvas, Color.ORANGE, 50, 50);
            Ball thirdBall = new Ball(canvas, Color.YELLOW, 50, 50);

            canvas.addBall(firstBall);
            canvas.addBall(secondBall);
            canvas.addBall(thirdBall);

            BallThread firstThread = new BallThread(firstBall, Thread.NORM_PRIORITY);
            BallThread secondThread = new BallThread(secondBall, firstThread);
            BallThread thirdThread = new BallThread(thirdBall, secondThread);

            thirdThread.start();
            secondThread.start();
            firstThread.start();
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonRedBall);
        buttonPanel.add(buttonBlueBall);
        buttonPanel.add(buttonBlueRedBalls);
        buttonPanel.add(buttonJoin);

        content.add(buttonPanel, BorderLayout.SOUTH);
        content.add(addTextFields(), BorderLayout.NORTH);
    }

    public void addPots(){
        canvas.addPot(new Pot(3, 3, potLabels.get(0)));
        canvas.addPot(new Pot(canvas.getWidth()-Pot.SIZE-3, 3, potLabels.get(1)));
        canvas.addPot(new Pot(3, canvas.getHeight()-Pot.SIZE-3, potLabels.get(2)));
        canvas.addPot(new Pot(canvas.getWidth()-Pot.SIZE-3, canvas.getHeight()-Pot.SIZE-3, potLabels.get(3)));
    }

    public JPanel addTextFields(){
        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 4; i++){
            JLabel potLabel = new JLabel("Pot " + (i+1));
            textFieldsPanel.add(potLabel);

            JLabel potCounter = new JLabel("0");
            potCounter.setForeground(Color.RED);
            textFieldsPanel.add(potCounter);
            potLabels.add(potCounter);
        }
        return textFieldsPanel;
    }
}
