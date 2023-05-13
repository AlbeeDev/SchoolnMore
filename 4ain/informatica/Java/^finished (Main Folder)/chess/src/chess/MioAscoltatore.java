package chess;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MioAscoltatore implements ActionListener {
	private int coordx,coordy,coordx2,coordy2,lastCapt;
	private int [][]mat= new int[8][8];
	private boolean sct,turno;
	private Color bg;
	private JButton selected,nextSelected;
	public MioAscoltatore(int[][] mat, boolean sct,boolean turno) {
		this.mat=mat;
		this.turno=turno;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(sct==true) {
			JButton b1 = (JButton) e.getSource();
			
			String[] strf = selected.getActionCommand().replaceAll("^\\D+","").split("\\D+");
			coordx= Integer.parseInt(strf[0]);
			coordy= Integer.parseInt(strf[1]);
			
			strf = b1.getActionCommand().replaceAll("^\\D+","").split("\\D+");
			coordx2= Integer.parseInt(strf[0]);
			coordy2= Integer.parseInt(strf[1]);
			
			if(((mat[coordx2][coordy2]<0) && (mat[coordx][coordy]>0)) || ((mat[coordx2][coordy2]>0) && (mat[coordx][coordy]<0)) || (mat[coordx2][coordy2]==0)) {
				if(Math.abs(mat[coordx][coordy])==3) {	
					for(int i=-2;i<=2;i++) {
						for(int j=-2;j<=2;j++) {
							if((Math.abs(i)!=Math.abs(j)) && ((coordx2==coordx+i) && (coordy2==coordy+j)) && (i!=0) && (j!=0)) {
								setNextSelected(e);
							}
						}
					}
				}
				if((Math.abs(mat[coordx][coordy])==2) || (Math.abs(mat[coordx][coordy])==5)) {
					boolean brk=false;
					for(int i=-7;i<=7;i++) {
						if((coordx2==coordx+i) && (coordy2==coordy+i) && (i!=0)) {
							System.out.println("confirm");
							for(int j=1;j<Math.abs(i);j++) {
								if((i<0) && (mat[coordx-j][coordy-j]!=0)) {
									brk=true;
								}
								if((i>0) && (mat[coordx+j][coordy+j]!=0)) {
									brk=true;
								}
							}
							if(!brk) {
								setNextSelected(e);
								break;
							}
						}
						if((coordx2==coordx+i) && (coordy2==coordy-i) && (i!=0)) {
							System.out.println("confirm");
							for(int j=1;j<Math.abs(i);j++) {
								if((i<0) && (mat[coordx-j][coordy+j]!=0)) {
									brk=true;
								}
								if((i>0) && (mat[coordx+j][coordy-j]!=0)) {
									brk=true;
								}
							}
							if(!brk) {
								setNextSelected(e);
								break;
							}
						}
					}
				}
				if((Math.abs(mat[coordx][coordy])==4) || (Math.abs(mat[coordx][coordy])==5)) {
					boolean brk=false;
					for(int i=-7;i<=7;i++) {
						if((coordx2==coordx+i) && (coordy2==coordy) && (i!=0)) {
							for(int j=1;j<Math.abs(i);j++) {
								if((i<0) && (mat[coordx-j][coordy]!=0)) {
									brk=true;
								}
								if((i>0) && (mat[coordx+j][coordy]!=0)) {
									brk=true;
								}
							}
							if(!brk) {
								setNextSelected(e);
								break;
							}
						}
						if((coordy2==coordy+i) && (coordx2==coordx) && (i!=0)) {
							for(int j=1;j<Math.abs(i);j++) {
								if((i<0) && (mat[coordx][coordy-j]!=0)) {
									brk=true;
								}
								if((i>0) && (mat[coordx][coordy+j]!=0)) {
									brk=true;
								}
							}
							if(!brk) {
								setNextSelected(e);
								break;
							}
						}
					}
				}
				if(Math.abs(mat[coordx][coordy])==6) {
					for(int i=-1;i<=1;i++) {
						for(int j=-1;j<=1;j++) {
							if((coordx2==coordx+i) && (coordy2==coordy+j)) {
								setNextSelected(e);
							}
						}
					}
				}
				if(Math.abs(mat[coordx][coordy])==1) {
					if(!turno) {
						if(((coordx2==coordx+1) && (coordy2==coordy) && (mat[coordx+1][coordy]==0)) || ((coordx2==coordx+1) && (coordy2==coordy+1) && (mat[coordx+1][coordy+1]!=0)) || ((coordx2==coordx+1) && (coordy2==coordy-1) && (mat[coordx+1][coordy-1]!=0)) || (((coordx2==coordx+2) && (coordy2==coordy) && (coordx==1) && (mat[coordx+1][coordy]==0) && (mat[coordx+2][coordy]==0)))) {
							setNextSelected(e);
						}
					}
					else {
						if(((coordx2==coordx-1) && (coordy2==coordy) && (mat[coordx-1][coordy]==0))  || ((coordx2==coordx-1) && (coordy2==coordy+1) && (mat[coordx-1][coordy+1]!=0)) || ((coordx2==coordx-1) && (coordy2==coordy-1) && (mat[coordx-1][coordy-1]!=0))  || (((coordx2==coordx-2) && (coordy2==coordy) && (coordx==6) && (mat[coordx-1][coordy]==0) && (mat[coordx-2][coordy]==0)))){
							setNextSelected(e);
						}
					}
				}
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						System.out.print(mat[i][j]);
					}
					System.out.println();
				}
			}
			if(lastCapt==6) {
				System.out.println("Vince il Nero");
				System.exit(0);
			}
			if(lastCapt==-6) {
				System.out.println("Vince il Bianco");
				System.exit(0);
			}
			selected.setBackground(bg);
			sct=false;
		}
		else {
			JButton b= (JButton) e.getSource();
			String[] strf = b.getActionCommand().replaceAll("^\\D+","").split("\\D+");
			coordx= Integer.parseInt(strf[0]);
			coordy= Integer.parseInt(strf[1]);
			if(((turno) && (mat[coordx][coordy]>0)) || ((!turno) && (mat[coordx][coordy]<0))) {
				selected = (JButton) e.getSource();
				bg=selected.getBackground();
				selected.setBackground(Color.RED);
				sct=true;
			}		
		}
	}
	public void setNextSelected(ActionEvent e){
		nextSelected = (JButton) e.getSource();
		nextSelected.setIcon(selected.getIcon());
		selected.setIcon(null);
		lastCapt=mat[coordx2][coordy2];
		mat[coordx2][coordy2]=mat[coordx][coordy];
		mat[coordx][coordy]=0;
		turno=!turno;
	}
}
