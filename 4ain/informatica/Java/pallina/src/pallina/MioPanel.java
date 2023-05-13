package pallina;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MioPanel extends JPanel{
	Image imm,bp,op;
	int []arr = new int[100000];
	int inc=0;
	double dt=0;
	double x=200;
	double vx=10;
	int vary=0,cony=20;
	double vy=cony;
	double y=50;
	boolean right=false;
	int immsize=20;
	int recth=500;
	public MioPanel() {
		//setBackground(Color.getHSBColor(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
		setBackground(Color.white);
		arr[inc++]=(int)x+immsize/2;
		arr[inc++]=(500-immsize)-(int) y+immsize/2;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			imm = ImageIO.read(new File("pallina.png")).getScaledInstance(immsize,immsize, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			
		}
		g.fillRect(0, recth, getWidth(), 100);
		g.drawImage(imm,(int) Math.round(x),(recth-immsize)-(int) y,null);
		if(inc>=3) {
			for(int i=3;i<arr.length;i+=2) {
				if(arr[i]==0) break;
				g.drawLine(arr[i-3], arr[i-2], arr[i-1], arr[i]);
			}
		}
		update();
	}
	
	public void update() {
		if(alive()) {
			dt+=0.001;
			x+=vx*dt;
			if(vx>0) {
				vx-=0.01;
			}
			y+=vy*dt;
			vy+=((-1/2.0)*9.81)*Math.pow(dt, 2);
			arr[inc++]=(int)x+immsize/2;
			arr[inc++]=(recth-immsize)-(int) y+immsize/2;
			System.out.println(y+" "+vy);
			repaint();
		}
		/*
		else {
			vy=cony-3;
			cony-=3;
			y=1;
			repaint();
		}
		*/
	}
	
	public boolean alive() {
		if(y>0 && cony>0) return true;
		return false;
	}

	
}
