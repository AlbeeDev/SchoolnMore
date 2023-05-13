package funzioni;

import java.awt.Graphics;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MioPanel extends JPanel{
	private double xmi;
	private double ymi;
	private double xma;
	private double yma;
	public MioPanel(int xmi,int ymi,int xma,int yma) {
		this.xmi=xmi;
		this.ymi=ymi;
		this.xma=xma;
		this.yma=yma;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0,getHf(),getWidth(),getHf());
		g.drawLine(getWf(),0,getWf(),getHeight());
		drawTick(g);
		drawFunc(g);
		
	}
	
	public int getWf() {
		return (int) (xmi* getWidth()/(xmi+xma));
	}
	
	public int getHf() {
		return (int) (ymi* getHeight()/(ymi+yma));
	}
	public int getXf(int x) {
		return (int) (x* getWidth()/(xmi+xma));	
	}
	public int getYf(int y) {
		return (int) (y* getHeight()/(ymi+yma));
	}
	
	
	public void drawFunc(Graphics g) {
		int x1 = 0,y1 = 0;
		boolean p1=false;
		int x2 = 0,y2 = 0;
		boolean p2=false;
		for(int x=-getWf();x<getWidth();x++) {
			for(int y=-getHf();y<getHeight();y++) {
				//funzione
				if(y==Math.pow(x,2)) {
					System.out.println(x+""+y);
					if(!p1) {
						x1=x;
						y1=y;
						p1=true;
					}
					else if(!p2) {
						x2=x;
						y2=y;
						p2=true;
					}
					if(p1 && p2) {
						g.drawLine(getWf()-getXf(x1),getHf()-getYf(y1),getWf()-getXf(x2),getHf()-getYf(y2));
						x1=x2;
						y1=y2;
						p2=false;
					}
					
				}
			}
		}
	}
	
	public void drawTick(Graphics g) {
		int lt=10;
		for(int i=0;i<getWf();i++) {
			//sinistra
			g.drawLine(getWf()-(i*getWidth()*lt/200), getHf()-5, getWf()-(i*getWidth()*lt/200), getHf()+5);
		}
		for(int i=0;i<(getWidth()-getWf());i++) {
			//destra
			g.drawLine(getWf()+(i*getWidth()*lt/200), getHf()-5, getWf()+(i*getWidth()*lt/200), getHf()+5);
		}
		for(int i=0;i<getHf();i++) {
			//basso
			g.drawLine(getWf()-5, getHf()-(i*getHeight()*lt/200), getWf()+5, getHf()-(i*getHeight()*lt/200));
		}
		for(int i=0;i<(getHeight()-getHf());i++) {
			//alto
			g.drawLine(getWf()-5, getHf()+(i*getHeight()*lt/200), getWf()+5, getHf()+(i*getHeight()*lt/200));
		}
	}
	
	
	
}
