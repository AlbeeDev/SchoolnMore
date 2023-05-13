import java.awt.*;
import java.awt.geom.*;
import java.util.function.Function;

import javax.swing.*;

@SuppressWarnings("serial")
public class Graph extends JPanel {
    private Function<Double, Double> function;

    public Graph(Function<Double, Double> function) {
        this.function = function;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLACK);

        double xMin = -10;
        double xMax = 10;
        double yMin = -10;
        double yMax = 10;

        double xScale = (double) getWidth() / (xMax - xMin);
        double yScale = (double) getHeight() / (yMax - yMin);

        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        g2.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        
        for (double x = xMin; x <= xMax; x += 0.01) {
            double y = function.apply(x);
            double x1 = (x - xMin) * xScale;
            double y1 = (y - yMin) * yScale;
            double x2 = ((x + 0.01) - xMin) * xScale;
            double y2 = (function.apply(x + 0.01) - yMin) * yScale;
            g2.draw(new Line2D.Double(x1, getHeight() - y1, x2, getHeight() - y2));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setTitle("Graph of Function");

        Function<Double, Double> function = x -> (5+3)/(Math.pow(x, 2)-4);
        Graph graph = new Graph(function);
        frame.add(graph);
        frame.setVisible(true);
    }
}