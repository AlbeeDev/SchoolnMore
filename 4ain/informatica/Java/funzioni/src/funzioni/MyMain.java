package funzioni;

import java.awt.Color;
import javax.swing.JFrame;

public class MyMain {

	public static void main(String[] args) {
		
		final int X_MIN=100;
		final int Y_MIN=100;
		final int X_MAX=100;
		final int Y_MAX=100;
		
		JFrame f = new JFrame();
		f.setSize(816,639);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int w=f.getContentPane().getWidth();
		int h=f.getContentPane().getHeight();
		
		
		MioPanel p = new MioPanel(X_MIN,Y_MIN,X_MAX,Y_MAX);
		p.setBounds(0, 0, w, h);
		p.setBackground(Color.pink);
		f.getContentPane().add(p);
		

		
		f.setVisible(true);
		

	}

}