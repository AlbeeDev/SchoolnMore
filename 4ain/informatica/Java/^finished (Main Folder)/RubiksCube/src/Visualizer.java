import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Visualizer extends JPanel implements KeyListener{
	int [][][]mat=new int[6][3][3];
	int mainf=0,updownf=1,sidef=2; //default face color
	int csize=100;
	int qw=csize/3;
	int qh=-csize/3;
	boolean modp=false;
	public Visualizer(int [][][]mat) {
		this.mat=mat;
		this.setBackground(Color.LIGHT_GRAY);
		setFocusable(true);
		addKeyListener(this);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int spoint=getWidth()/5;
		g.setColor(Color.black);
		for(int i=0;i<=3;i++) {
			for(int j=0;j<=3;j++) {
				g.drawLine(spoint, spoint+(csize*i), spoint+(csize*3), spoint+(csize*i));
				g.drawLine(spoint+(csize*j), spoint, spoint+(csize*j), spoint+(csize*3));
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				g.setColor(getcolor(mat[mainf][i][j]));
				g.fillRect(spoint+(csize*j)+1, spoint+(csize*i)+1, csize-2, csize-2);
			}
		}
		
		g.setColor(Color.black);
		for(int i=0;i<=3;i++) {
			for(int j=0;j<=3;j++) {
				//updownf
				g.drawLine(spoint+(qw*i),spoint+(csize*getcoord(qh))+(qh*i),spoint+(csize*3)+(qw*i),spoint+(csize*getcoord(qh))+(qh*i));
				//sidef
				g.drawLine(spoint+(csize*getcoord(qw))+(qw*j),spoint+(qh*j),spoint+(csize*getcoord(qw))+(qw*j),spoint+(csize*3)+(qh*j));
			}
		}
		
		for(int i=0;i<=3;i++) {
			for(int j=0;j<=3;j++) {
				if(i==getcoord(qh) || j==getcoord(qw)) {
					g.drawLine(spoint+(csize*j), spoint+(csize*i), spoint+(csize*j)+(qw*3), spoint+(csize*i)+(qh*3));
				}
			}
		}
		
		//fill updownf
		if(getcoord(qh)==0) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					g.setColor(getcolor(mat[updownf][i][j]));
					int []arrx= {spoint+(qw*(2-i))+(csize*j)+2,spoint+(qw*(2-i+1))+(csize*j)+1,spoint+(qw*(2-i+1))+(csize*(j+1))-2,spoint+(qw*(2-i))+(csize*(j+1))-1};
					int []arry= {spoint+(csize*getcoord(qh))+(qh*(2-i))+getoffset(qh),spoint+(csize*getcoord(qh))+(qh*(2-i+1))-getoffset(qh),spoint+(csize*getcoord(qh))+(qh*(2-i+1))-getoffset(qh),spoint+(csize*getcoord(qh))+(qh*(2-i))+getoffset(qh)};
					g.fillPolygon(arrx, arry, 4);
				}
			}
		}
		else {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					g.setColor(getcolor(mat[updownf][i][j]));
					int []arrx= {spoint+(qw*i)+(csize*j)+2,spoint+(qw*(i+1))+(csize*j)+1,spoint+(qw*(i+1))+(csize*(j+1))-2,spoint+(qw*i)+(csize*(j+1))-1};
					int []arry= {spoint+(csize*getcoord(qh))+(qh*i)+getoffset(qh),spoint+(csize*getcoord(qh))+(qh*(i+1))-getoffset(qh),spoint+(csize*getcoord(qh))+(qh*(i+1))-getoffset(qh),spoint+(csize*getcoord(qh))+(qh*i)+getoffset(qh)};
					g.fillPolygon(arrx, arry, 4);
				}
			}
		}
		
		
		//fill sidef
		if(getcoord(qw)==0) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					g.setColor(getcolor(mat[sidef][i][j]));
					int []arrx= {spoint+(csize*getcoord(qw)+(qw*(2-j)))+getoffset(qw),spoint+(csize*getcoord(qw))+(qw*(2-j+1))-getoffset(qw),spoint+(csize*getcoord(qw))+(qw*(2-j+1))-getoffset(qw),spoint+(csize*getcoord(qw)+(qw*(2-j)))+getoffset(qw)};
					int []arry= {spoint+(csize*i)+(qh*(2-j))+1,spoint+(csize*i)+(qh*(2-j+1))+2,spoint+(csize*(i+1))+(qh*(2-j+1))-1,spoint+(csize*(i+1))+(qh*(2-j))-1};
					g.fillPolygon(arrx, arry, 4);
					
				}
			}
		}
		else {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					g.setColor(getcolor(mat[sidef][i][j]));
					int []arrx= {spoint+(csize*getcoord(qw)+(qw*j))+getoffset(qw),spoint+(csize*getcoord(qw))+(qw*(j+1))-getoffset(qw),spoint+(csize*getcoord(qw))+(qw*(j+1))-getoffset(qw),spoint+(csize*getcoord(qw)+(qw*j))+getoffset(qw)};
					int []arry= {spoint+(csize*i)+(qh*j)+1,spoint+(csize*i)+(qh*(j+1))+2,spoint+(csize*(i+1))+(qh*(j+1))-1,spoint+(csize*(i+1))+(qh*j)-1};
					g.fillPolygon(arrx, arry, 4);
					
				}
			}
		}
		
	}
	public int getcoord(int q) {
		if(q<0) return 0;
		else return 3;
	}
	public int getoffset(int q) {
		int offval=1;
		if(getcoord(q)==0) return -offval;
		return offval;
	}
	public int getopposite(int num) {
		if(num>2) num-=3;
		else num+=3;
		return num;
	}
	public Color getcolor(int num) {
		int i=0;
		if(num==i++) return Color.white;
		if(num==i++) return Color.blue;
		if(num==i++) return Color.red;
		if(num==i++) return Color.yellow;
		if(num==i++) return Color.green;
		if(num==i) return Color.orange;
		return null;
	}
	public void rotatemat(int mat[][]) {
		int temp=mat[0][0];
		mat[0][0]=mat[2][0];
		mat[2][0]=mat[2][2];
		mat[2][2]=mat[0][2];
		mat[0][2]=temp;
		temp=mat[0][1];
		mat[0][1]=mat[1][0];
		mat[1][0]=mat[2][1];
		mat[2][1]=mat[1][2];
		mat[1][2]=temp;
	}
	public int getprim() {
		if(modp) return 3;
		else return 1;
	}
	public void godmove(int rowcol,int type) {
		int []t=new int[3];
		if(type ==1) {
			for(int k=0;k<getprim();k++) {
				if(qw<0) {
					if(rowcol==0) {
						rotatemat(mat[sidef]);
						rotatemat(mat[sidef]);
						rotatemat(mat[sidef]);
					}
					else {
						rotatemat(mat[getopposite(sidef)]);
					}
				}
				else {
					if(rowcol==2) {
						rotatemat(mat[sidef]);
					}
					else {
						rotatemat(mat[getopposite(sidef)]);
						rotatemat(mat[getopposite(sidef)]);
						rotatemat(mat[getopposite(sidef)]);
					}
				}
				for(int i=0;i<3;i++) {
					t[i]=mat[mainf][i][rowcol];
					if(qh>0) {
						mat[mainf][i][rowcol]=mat[updownf][i][rowcol];
						mat[updownf][i][rowcol]=mat[getopposite(mainf)][i][rowcol];
						mat[getopposite(mainf)][i][rowcol]=mat[getopposite(updownf)][i][rowcol];
						mat[getopposite(updownf)][i][rowcol]=t[i];
					}
					else {
						mat[mainf][i][rowcol]=mat[getopposite(updownf)][i][rowcol];
						mat[getopposite(updownf)][i][rowcol]=mat[getopposite(mainf)][i][rowcol];
						mat[getopposite(mainf)][i][rowcol]=mat[updownf][i][rowcol];
						mat[updownf][i][rowcol]=t[i];
					}
				}
			}
		}
		if(type==2) {
			for(int k=0;k<getprim();k++) {
				if(qh<0) {
					if(rowcol==0) {
						rotatemat(mat[updownf]);
					}
					else {
						rotatemat(mat[getopposite(updownf)]);
						rotatemat(mat[getopposite(updownf)]);
						rotatemat(mat[getopposite(updownf)]);
					}
					
				}
				else {
					if(rowcol==2) {
						rotatemat(mat[updownf]);
						rotatemat(mat[updownf]);
						rotatemat(mat[updownf]);
					}
					else {
						rotatemat(mat[getopposite(updownf)]);
					}
				}
				for(int i=0;i<3;i++) {
					t[i]=mat[mainf][rowcol][i];
					if(qw>0) {
						mat[mainf][rowcol][i]=mat[sidef][rowcol][i];
						mat[sidef][rowcol][i]=mat[getopposite(mainf)][Math.abs(rowcol-2)][Math.abs(2-i)];
						mat[getopposite(mainf)][Math.abs(rowcol-2)][Math.abs(2-i)]=mat[getopposite(sidef)][rowcol][i];
						mat[getopposite(sidef)][rowcol][i]=t[i];
					}
					else {
						mat[mainf][rowcol][i]=mat[getopposite(sidef)][rowcol][i];
						mat[getopposite(sidef)][rowcol][i]=mat[getopposite(mainf)][Math.abs(rowcol-2)][Math.abs(2-i)];
						mat[getopposite(mainf)][Math.abs(rowcol-2)][Math.abs(2-i)]=mat[sidef][rowcol][i];
						mat[sidef][rowcol][i]=t[i];
					}
				}
			}
		}
		if(type==3) {
			for(int k=0;k<getprim();k++) {
				if(rowcol==0) {
					rotatemat(mat[mainf]);
				}
				else {
					rotatemat(mat[getopposite(mainf)]);
					rotatemat(mat[getopposite(mainf)]);
					rotatemat(mat[getopposite(mainf)]);
				}
				for(int i=0;i<3;i++) {
					if(qw>0) {
						if(qh<0) {
							t[i]=mat[sidef][i][rowcol];
							mat[sidef][i][rowcol]=mat[updownf][2-rowcol][i];
							mat[updownf][2-rowcol][i]=mat[getopposite(sidef)][2-i][2-rowcol];
							mat[getopposite(sidef)][2-i][2-rowcol]=mat[getopposite(updownf)][rowcol][2-i];
							mat[getopposite(updownf)][rowcol][2-i]=t[i];
						}
						else {
							t[i]=mat[sidef][i][rowcol];
							mat[sidef][i][rowcol]=mat[getopposite(updownf)][2-rowcol][i];
							mat[getopposite(updownf)][2-rowcol][i]=mat[getopposite(sidef)][2-i][2-rowcol];
							mat[getopposite(sidef)][2-i][2-rowcol]=mat[updownf][rowcol][2-i];
							mat[updownf][rowcol][2-i]=t[i];
						}
						
					}
					else {
						if(qh<0) {
							t[i]=mat[getopposite(sidef)][i][rowcol];
							mat[getopposite(sidef)][i][rowcol]=mat[updownf][2-rowcol][i];
							mat[updownf][2-rowcol][i]=mat[sidef][2-i][2-rowcol];
							mat[sidef][2-i][2-rowcol]=mat[getopposite(updownf)][rowcol][2-i];
							mat[getopposite(updownf)][rowcol][2-i]=t[i];
						}
						else {
							t[i]=mat[getopposite(sidef)][i][rowcol];
							mat[getopposite(sidef)][i][rowcol]=mat[getopposite(updownf)][2-rowcol][i];
							mat[getopposite(updownf)][2-rowcol][i]=mat[sidef][2-i][2-rowcol];
							mat[sidef][2-i][2-rowcol]=mat[updownf][rowcol][2-i];
							mat[updownf][rowcol][2-i]=t[i];
						}
					}
				}
			}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		int key= e.getKeyCode();
		switch (key) {
		
		case KeyEvent.VK_SHIFT:
			modp=!modp;
			System.out.println("' "+modp);
			break;
		case KeyEvent.VK_F:
			godmove(0, 3);
			repaint();
			break;
		
		case KeyEvent.VK_R:
			godmove(2, 3);
			repaint();
			break;
			
		case KeyEvent.VK_W:
			godmove(0, 2);
			repaint();
			break;
			
		case KeyEvent.VK_S:
			godmove(2, 2);
			repaint();
			break;
			
		case KeyEvent.VK_A:
			godmove(0,1);
			repaint();
			break;
		case KeyEvent.VK_D:
			godmove(2,1);
			repaint();
			break;
		case KeyEvent.VK_UP: 
			if(qh>0) {
				qh=-qh;
				updownf-=3;
				if(updownf<0) updownf+=6;
			}	
			else {
				int temp=mainf;
				mainf=updownf;
				updownf=temp+3;
				if(updownf>5) updownf-=6;
				if(qw>0) {
					rotatemat(mat[sidef]);
					rotatemat(mat[sidef]);
					rotatemat(mat[sidef]);
					rotatemat(mat[getopposite(sidef)]);
				}
				else {
					rotatemat(mat[sidef]);
					rotatemat(mat[getopposite(sidef)]);
					rotatemat(mat[getopposite(sidef)]);
					rotatemat(mat[getopposite(sidef)]);
				}
				
			}
			repaint();
			break;
		case KeyEvent.VK_DOWN: 
			if(qh<0) {
				qh=-qh;
				updownf+=3;
				if(updownf>5) updownf-=6;
			}
			else {
				int temp=mainf;
				mainf=updownf;
				updownf=temp-3;
				if(updownf<0) updownf+=6;
				if(qw>0) {
					rotatemat(mat[sidef]);
					rotatemat(mat[getopposite(sidef)]);
					rotatemat(mat[getopposite(sidef)]);
					rotatemat(mat[getopposite(sidef)]);
				}
				else {
					rotatemat(mat[sidef]);
					rotatemat(mat[sidef]);
					rotatemat(mat[sidef]);
					rotatemat(mat[getopposite(sidef)]);
				}
				if(updownf==3) {
					rotatemat(mat[updownf]);
					rotatemat(mat[updownf]);
				}
				if(mainf==0) {
					rotatemat(mat[getopposite(mainf)]);
					rotatemat(mat[getopposite(mainf)]);
				}
			}
			repaint();
			break;
		case KeyEvent.VK_LEFT: 
			if(qw>0) {
				qw=-qw;
				sidef+=3;
				if(sidef>5) sidef-=6;
			}
			else {
				int temp=mainf;
				mainf=sidef;
				sidef=temp-3;
				if(sidef<0) sidef+=6;
				if(qh<0) {
					rotatemat(mat[updownf]);
					rotatemat(mat[updownf]);
					rotatemat(mat[updownf]);
					rotatemat(mat[getopposite(updownf)]);
				}
				else {
					rotatemat(mat[updownf]);
					rotatemat(mat[getopposite(updownf)]);
					rotatemat(mat[getopposite(updownf)]);
					rotatemat(mat[getopposite(updownf)]);
				}
				rotatemat(mat[sidef]);
				rotatemat(mat[sidef]);
				rotatemat(mat[getopposite(mainf)]);
				rotatemat(mat[getopposite(mainf)]);
				
			}
			repaint();
			break;
		case KeyEvent.VK_RIGHT: 
			if(qw<0) {
				qw=-qw;
				sidef-=3;
				if(sidef<0) sidef+=6;
			}
			else {
				int temp=mainf;
				mainf=sidef;
				sidef=temp+3;
				if(sidef>5) sidef-=6;
				if(qh<0) {
					rotatemat(mat[updownf]);
					rotatemat(mat[getopposite(updownf)]);
					rotatemat(mat[getopposite(updownf)]);
					rotatemat(mat[getopposite(updownf)]);
				}
				else {
					rotatemat(mat[updownf]);
					rotatemat(mat[updownf]);
					rotatemat(mat[updownf]);
					rotatemat(mat[getopposite(updownf)]);
				}
				rotatemat(mat[sidef]);
				rotatemat(mat[sidef]);
				rotatemat(mat[getopposite(mainf)]);
				rotatemat(mat[getopposite(mainf)]);
			}
			
			repaint();
			break;
		}
	}
	
}
