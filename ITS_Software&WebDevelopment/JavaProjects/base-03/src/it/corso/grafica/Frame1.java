package it.corso.grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frame1 extends JFrame {
    JPanel pannello;
    JButton pulsante;
    JTextField casella;
    JLabel testo;
    JButton theme;

    JFrame frameReference = this;


    public Frame1() throws InterruptedException {
        this.setTitle("Nuovo Frame");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        pannello = getPanel();
        this.add(pannello);

        this.setVisible(true);
        /*
        List<JPanel> panels = new ArrayList<JPanel>();
        while (true){
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    JPanel panel = getColoredPanel(i,j);
                    panels.add(panel);
                    this.add(panel);
                }
            }
            this.repaint();
            Thread.sleep(10);
            for(JPanel panel : panels){
                this.remove(panel);
            }
        }

*/
        pulsante.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = casella.getText();
                testo.setText(text);
                casella.setText("");
            }
        });

        theme.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                pannello.setBackground(getRandomColor());
                pulsante.setBackground(getRandomColor());
                testo.setForeground(getRandomColor());
                frameReference.repaint();
            }
        });


    }

    public JPanel getPanel(){
        JPanel panel = new JPanel(null);
        panel.setBackground(getRandomColor());
        casella = new JTextField();
        casella.setBounds(10,10,200,25);
        panel.add(casella);
        pulsante = new JButton("Pulsante");
        pulsante.setBackground(getRandomColor());
        pulsante.setBounds(10,50,200,25);
        panel.add(pulsante);
        testo = new JLabel("output");
        testo.setForeground(getRandomColor());
        testo.setBounds(10,100,200,25);
        panel.add(testo);
        theme = new JButton("Theme");
        theme.setBounds(300,10,100,25);
        panel.add(theme);
        return panel;
    }

    public JPanel getColorPanel(int i, int j) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(i * 10, j * 10, 10, 10);
        panel.setBackground(getRandomColor());
        return panel;
    }

    public static Color getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);   // Generates a random integer between 0-255
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        return new Color(red, green, blue);
    }

    public static void main(String[] args) throws InterruptedException {
        new Frame1();
    }

}
