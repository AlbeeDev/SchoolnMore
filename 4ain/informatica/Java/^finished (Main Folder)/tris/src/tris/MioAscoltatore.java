package tris;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

public class MioAscoltatore implements ActionListener {
	int coordx,coordy;
	int [][]mat= new int[3][3];
	JButton[] bvec = new JButton[9];
	public MioAscoltatore(int[][] mat, JButton[] bvec) {
		this.mat=mat;
		this.bvec=bvec;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		String[] strf = b.getActionCommand().replaceAll("^\\D+","").split("\\D+");
		coordx= Integer.parseInt(strf[0]);
		coordy= Integer.parseInt(strf[1]);
		
		if(mat[coordx][coordy]==0) {
			mat[coordx][coordy]=1;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println("");
			}
			System.out.println("");
			
			checkwin(mat);
			
			b.setFont(new Font(null,Font.PLAIN,50));
			b.setText("X");
			
			while(true) {
				boolean breaker=false;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(mat[i][j]==0) {
							breaker=true;
							break;
						}
						if(i==2 && j==2) {
							System.out.println("Pareggio");
							System.exit(0);
						}
					}
					if(breaker) {
						break;
					}
				}
				break;
			}
			do {
			coordx= new Random().nextInt(3);
			coordy= new Random().nextInt(3);
			} while(mat[coordx][coordy]!=0);
			
			mat[coordx][coordy]=-1;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(mat[i][j]+" ");
				}
				System.out.println("");
			}
			System.out.println("");
			
			checkwin(mat);
			
			for(int r=0;r<3;r++) {
				for(int c=0;c<3;c++) {
					strf = bvec[r*3+c].getActionCommand().replaceAll("^\\D+","").split("\\D+");
					if(Integer.parseInt(strf[0])==coordx && Integer.parseInt(strf[1])==coordy) {
						bvec[r*3+c].setFont(new Font(null,Font.PLAIN,50));
						bvec[r*3+c].setText("O");
					}
				}
			}
			
		}
		
	}
	public static void checkwin(int [][]mat) {
		
		int diag1=0,diag2=0,oriz1=0,oriz2=0,oriz3=0,vert1=0,vert2=0,vert3=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==j) {
					diag1+=mat[i][j];
				}
				if(i==(2-j)) {
					diag2+=mat[i][j];
				}
				if(i==0) {
					oriz1+=mat[i][j];
				}
				if(i==1) {
					oriz2+=mat[i][j];
				}
				if(i==2) {
					oriz3+=mat[i][j];
				}
				if(j==0) {
					vert1+=mat[i][j];
				}
				if(j==1) {
					vert2+=mat[i][j];
				}
				if(j==2) {
					vert3+=mat[i][j];
				}
			}
			
		}
		if((diag1==3) || (diag2==3) || (oriz1==3) || (oriz2==3) || (oriz3==3) || (vert1==3) || (vert2==3) || (vert3==3)){
			System.out.println("hai vinto");
			System.exit(0);
		}
		if((diag1==-3) || (diag2==-3) || (oriz1==-3) || (oriz2==-3) || (oriz3==-3) || (vert1==-3) || (vert2==-3) || (vert3==-3)){
			System.out.println("hai perso");
			System.exit(0);
		}
	}
}