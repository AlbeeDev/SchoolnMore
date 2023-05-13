package triagrid;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MioPanel extends JPanel{
	int sv,so;
	boolean b=false;
	public MioPanel(int sv, int so) {
		this.sv=sv;
		this.so=so;
		setBackground(Color.pink);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(so==0 || sv==0) return;
		//System.out.print(sv/2.0f);
		g.drawLine(0,getHeight()-1,getWidth(),getHeight()-1);
		for(int i=0;i<so;i++) {
			int temp=i*getWidth()/(so*2);
			g.drawLine(temp, (so-i)*getHeight()/so, getWidth()-temp, (so-i)*getHeight()/so);
		}
		for(int i=0;i<=sv;i++) {
			int temp=i*getWidth()/sv;
			g.drawLine(getWidth()/2, 0, temp, getHeight());
		}
		
		
	}
}
