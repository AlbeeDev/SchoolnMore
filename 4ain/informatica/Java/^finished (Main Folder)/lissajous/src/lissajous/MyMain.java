package lissajous;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
@SuppressWarnings("serial")
class Pannello extends JPanel{
	double m = 4./3, q = Math.toRadians(23);
	public Pannello() {
		setBackground(Color.PINK);
	}

	public void setM(double m) {
		this.m = m;
	}
	public void setQ(double q) {
		this.q = q;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.translate(getWidth()/2,getHeight()/2);
		//m=Math.sqrt(2);
		for(int angle=0; angle<360*100; angle++) {
			double theta = Math.toRadians(angle);
			int x = (int) (100*Math.cos(theta));
			int y = (int) (100*Math.sin(m*theta + q));
			g.drawLine(x, y, x, y);
		}
	}
	
}
public class MyMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Lissajous");
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		Pannello pannello = new Pannello();
		pannello.setBounds(0,0,frame.getWidth(),frame.getHeight());
		frame.add(pannello);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL,1,100,1);
		slider.setBounds(0, 0, frame.getWidth(), 50);
		frame.add(slider);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				pannello.setM(1./slider.getValue());
				pannello.repaint();			}
		});
		
		
		frame.setVisible(true);
	}

}
