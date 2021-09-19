import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BounceFrame extends JFrame {
    private BallCanvas canvas;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

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

        buttonStart.addActionListener(e -> {
            Ball b = new Ball(canvas);
            canvas.addBall(b);

            BallThread thread = new BallThread(b);
            thread.start();
            System.out.println("Thread name = " +
                    thread.getName());
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

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
