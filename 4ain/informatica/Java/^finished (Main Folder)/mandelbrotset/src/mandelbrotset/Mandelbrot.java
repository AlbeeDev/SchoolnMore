package mandelbrotset;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Mandelbrot extends JFrame {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int MAX_ITER = 1000;

    public Mandelbrot() {
        setSize(WIDTH, HEIGHT);
        setTitle("Mandelbrot Set");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        double minX = -2.0;
        double maxX = 1.0;
        double minY = -1.5;
        double maxY = 1.5;

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double cReal = minX + (maxX - minX) * x / WIDTH;
                double cImag = minY + (maxY - minY) * y / HEIGHT;
                double zReal = 0;
                double zImag = 0;
                int iterations = 0;

                while (zReal * zReal + zImag * zImag < 4 && iterations < MAX_ITER) {
                    double zRealTemp = zReal * zReal - zImag * zImag + cReal;
                    zImag = 2 * zReal * zImag + cImag;
                    zReal = zRealTemp;
                    iterations++;
                }

                int color = iterations % 256;
                image.setRGB(x, y, new Color(color, color, color).getRGB());
            }
        }

        add(new JLabel(new ImageIcon(image)));
    }

    public static void main(String[] args) {
        Mandelbrot mandelbrot = new Mandelbrot();
        mandelbrot.setVisible(true);
    }
}
