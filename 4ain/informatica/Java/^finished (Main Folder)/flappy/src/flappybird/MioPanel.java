package flappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class MioPanel extends JPanel{
	//flappy
	Image imm;
	Timer tim = null;
	double dt=500,x=200,vx=0.0/dt,cony=1.5,vy=1.5,y=100;
	boolean right=false,widthf=false;
	int immsize=75;
	int frame=2,lf=1;
	int count=0;
	//tower
	double xtow=600,vxtow=-4.0/dt;
	int[] h1=new int[6];
	int[] h2 = new int[6];
	public MioPanel() {
		setBackground(Color.cyan);
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode= e.getKeyCode();
				
				switch (keycode) {
				case KeyEvent.VK_SPACE:
					vy=cony;
					break;
				default:
					break;
				}
			}
		}); 
		for(int i=0;i<6;i++) {
			h1[i]=new Random().nextInt(250)+200;
			h2[i]=600-h1[i];
		}
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//setBackground(Color.getHSBColor(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
		try {
			/*
			if(count%50==0) {
				if(frame==1) {
					frame=2;
					lf=1;
				}
				else if(frame==3) {
					frame=2;
					lf=3;
				}
				else if(frame==2) {
					if(lf==1) frame=3;
					if(lf==3) frame=1;
				}
			}
			count+=1;
			*/
			imm = ImageIO.read(new File("1 bird "+frame+".png")).getScaledInstance(immsize,immsize, Image.SCALE_SMOOTH);
			
		} catch (IOException e) {
			
		}
		if(y>getHeight()-70) {
			y=getHeight()-70;
		}
		
		g.drawImage(imm,(int) Math.round(x),(getHeight()-immsize)-(int) y,null);
		
		if(xtow<-150) {
			xtow+=400;
			rotatearr(h1);
			rotatearr(h2);
		}
		for(int i=0;i<3;i++) {
			g.setColor(Color.green);
			//g.fillRect((int) xtow + 400*i, 0-150, 100, h1[i]);
			//g.fillRect((int) xtow + 400*i, h1[i]+100, 100, h2[i]);
		}
		
		ActionListener tp = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(alive()) {
					update();
				}
				
			}
		};
		tim = new Timer((int) dt, tp);
		tim.start();     
	}
	
	private void rotatearr(int arr[]) {
		int temp=arr[0];
		for(int i=0;i<arr.length-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[arr.length-1]=temp;
	}

	public void update() {
		if(alive()) {
			xtow+=vxtow;
			x+=vx;
			vx*=1.0001;
			y+=vy;
			vy-=0.007;
			repaint();
		}
		if(!alive()){
			vy=cony;
			y=1;
			repaint();
		}
		
	}
	
	public boolean alive() {
		if(y>0) return true;
		return false;
	}
	
}