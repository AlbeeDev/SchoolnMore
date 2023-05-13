package portal;

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
	double dt=0;
	double x=200;
	double vel=10;
	double y=200;
	boolean right=false;
	int immsize;
	int recth;
	public MioPanel() {
		//setBackground(Color.getHSBColor(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
		setBackground(Color.white);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		immsize = 20;
		try {
			imm = ImageIO.read(new File("pallina.png")).getScaledInstance(immsize,immsize, Image.SCALE_SMOOTH);
			bp= ImageIO.read(new File("blue.jpg")).getScaledInstance(100,100, Image.SCALE_SMOOTH);
			op= ImageIO.read(new File("orange.png")).getScaledInstance(100,100, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			
		}
		recth=(int) (getHeight()/1.2);
		
		g.fillRect(0, recth, getWidth(), 100);
		g.drawImage(bp,560,50,null);
		g.drawImage(op,560,recth,null);
		g.drawImage(bp,160,50,null);
		g.drawImage(op,160,recth,null);
		g.drawImage(imm,(int) Math.round(x),(recth-immsize)-(int) y,null);
		update();
	}
	
	public void update() {
		if(alive()) {
			dt+=0.01;
			//x+=vel*dt;
			//accel*=1.01;
			y+= ((-1/2.0)*9.81)*Math.pow(dt, 2);
			System.out.println(y);
			repaint();
		}
		else {
			if(right) {
				x=200;
				right=false;
			}
			else {
				x=600;
				right=true;
			}
			y=350;
			
			repaint();
		}
	}
	
	public boolean alive() {
		//(x<getWidth()-immsize)
		System.out.println(recth+" "+getHeight()+" "+(getHeight()-recth)+" "+(getHeight()-recth-immsize-immsize));
		if(y>-50) return true;
		return false;
	}

	
}