package grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyMain {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int len=6; //numero di punti variabile
		
		JTextField[] xvec = new JTextField[len];
		JTextField[] yvec = new JTextField[len];
		for(int i=0;i<len;i++){
			xvec[i]=new JTextField("100");
			xvec[i].setBounds(600, (i+1)*40, 50, 20);
			frame.add(xvec[i]);
			yvec[i]=new JTextField("100");
			yvec[i].setBounds(700, (i+1)*40, 50, 20);
			frame.add(yvec[i]);
		}
		
		JPanel mioPannello = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					int x1=Integer.parseInt(xvec[0].getText());
					int y1=Integer.parseInt(yvec[0].getText());
					int x2=Integer.parseInt(xvec[len-1].getText());
					int y2=Integer.parseInt(yvec[len-1].getText());
					g.drawLine(x1,y1,x2,y2);
				}catch(NumberFormatException e) {}
				for(int i=0;i<len-1;i++) {
					try {
						int x1=Integer.parseInt(xvec[i].getText());
						int y1=Integer.parseInt(yvec[i].getText());
						int x2=Integer.parseInt(xvec[i+1].getText());
						int y2=Integer.parseInt(yvec[i+1].getText());
						g.drawLine(x1,y1,x2,y2);
					}catch(NumberFormatException e) {}
				}
			}
		};
		mioPannello.setBackground(Color.CYAN);
		mioPannello.setBounds(10, 10, 550, 500);
		frame.add(mioPannello);

		KeyListener k = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				mioPannello.repaint();
			}
		};
		
		for(int i=0;i<len;i++){
			xvec[i].addKeyListener(k);
			yvec[i].addKeyListener(k);
		}

		frame.setVisible(true);
	}
}