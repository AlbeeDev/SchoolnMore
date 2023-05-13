package animaphy;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FallingObject extends JPanel {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    private double bounce;
    private int radius;
    private Timer timer;

    public FallingObject(int radius) {
        this.radius = radius;
        x = 100;
        y = 100;
        vx = 50;
        vy = 1;
        ax = 0;
        ay = 9.8; // acceleration due to gravity
        bounce = 0.7;
        setPreferredSize(new Dimension(300, 300));
        timer = new Timer(1000 / 60, e -> {
            x += vx;
            y += vy;
            vy += ay;
            vx += ax;
            bounce+=0;
            if (y + radius > getHeight()) {
                y = getHeight() - radius;
                vy = -vy * bounce; // add some bounciness
            }
            if(x+radius > getWidth() || x-radius<0) {
            	vx= -vx; 
            }
            repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Falling Object Simulation");
        FallingObject panel = new FallingObject(20);
        panel.setBackground(Color.lightGray);
        frame.add(panel);
        frame.setVisible(true);
    }
}
