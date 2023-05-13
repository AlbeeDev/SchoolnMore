package imagegui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MioGrafico extends JPanel{

	boolean drawg;
	
	public MioGrafico() {
		setBackground(Color.red);
		drawg=false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(drawg) {
			int x=0,y=0;
			for(double xm=0;xm<1;xm+=1/300.0) {
				for(double ym=0;ym<1;ym+=1/300.0) {
					int xf=(int) (xm*300);
					int yf=(int) (ym*300); 
					if(Math.round(xm*100)==Math.round((ym/xm)*100)) {
						g.drawLine(x, y, xf, yf);
						x=xf;
						y=yf;
					}
				}
			}
			
		}
	}
	
	
	
	
}