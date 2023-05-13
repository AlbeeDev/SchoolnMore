import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HilbertCurve extends JPanel {
    
    private final int order;
    private final int length;
    
    public HilbertCurve(int order) {
        this.order = order;
        this.length = (int) Math.pow(2, order) - 1;
        setPreferredSize(new java.awt.Dimension(800, 600));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHilbertCurve(g, order, new Point(0, length), length, 0);
    }
    
    private void drawHilbertCurve(Graphics g, int order, Point start, int length, int direction) {
        if (order == 0) {
            g.drawLine(start.x, start.y, start.x, start.y);
            return;
        }
        int halfLength = length / 2;
        Point middle = new Point(start.x + halfLength, start.y + halfLength);
        switch (direction) {
            case 0: // right
                drawHilbertCurve(g, order - 1, start, halfLength, 0);
                drawHilbertCurve(g, order - 1, new Point(start.x, start.y + halfLength), halfLength, 1);
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y + halfLength), halfLength, 0);
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y), halfLength, 3);
                break;
            case 1: // down
                drawHilbertCurve(g, order - 1, new Point(start.x, start.y + halfLength), halfLength, 1);
                drawHilbertCurve(g, order - 1, start, halfLength, 2);
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y), halfLength, 1);
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y + halfLength), halfLength, 0);
                break;
            case 2: // left
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y), halfLength, 3);
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y + halfLength), halfLength, 2);
                drawHilbertCurve(g, order - 1, middle, halfLength, 1);
                drawHilbertCurve(g, order - 1, new Point(start.x, start.y + halfLength), halfLength, 0);
                break;
            case 3: // up
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y + halfLength), halfLength, 0);
                drawHilbertCurve(g, order - 1, new Point(start.x + halfLength, start.y), halfLength, 3);
                drawHilbertCurve(g, order - 1, new Point(start.x, start.y), halfLength, 2);
                drawHilbertCurve(g, order - 1, new Point(start.x, start.y + halfLength), halfLength, 1);
                break;
            }
            }
    
            public static void main(String[] args) {
                int order = 9;
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new HilbertCurve(order));
                frame.pack();
                frame.setVisible(true);
            }
	}