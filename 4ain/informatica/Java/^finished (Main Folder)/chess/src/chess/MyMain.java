package chess;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain {

	public static void main(String[] args) throws IOException{
		
		boolean isSelected=false;
		boolean turno=true;
		
		JFrame frame = new JFrame();
		frame.setTitle("TRIS");
		frame.setSize(960,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setLayout(new GridLayout(8,8));
		
		int [][]mat= new int[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				mat[i][j]=0;
			}
		}
		
		
		JButton[] bvec = new JButton[64];
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				bvec[r*8 + c] = new JButton();
				frame.add(bvec[r*8 + c]);
				if(r%2==0) {
					if(c%2==0) {
						bvec[r*8 + c].setBackground(Color.WHITE);
					}
					else {
						bvec[r*8 + c].setBackground(Color.LIGHT_GRAY);
					}
				}
				else {
					if(c%2==0) {
						bvec[r*8 + c].setBackground(Color.LIGHT_GRAY);
					}
					else {
						bvec[r*8 + c].setBackground(Color.WHITE);
					}
				}
			}
		}
		
		setPieces(bvec,mat);
		
		MioAscoltatore al=new MioAscoltatore(mat,isSelected,turno);
		
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				bvec[r*8+c].addActionListener(al);
			}
		}
		
		frame.setVisible(true);
		
	}
	public static void setPieces(JButton [] bvec,int[][] mat) throws IOException {
		
		for(int r=0;r<8;r++) {
			for(int c=0;c<8;c++) {
				int idx=r*8+c;
				bvec[idx].setActionCommand(r+" "+c);
				
				ImageIcon icon= new ImageIcon();
				
				if((idx==1) || (idx==6) || (idx==57) || (idx==62)) {
					if(idx<40) {
						mat[r][c]=-3;
						icon.setImage(ImageIO.read(new File("src/chess/BH.png")));
						bvec[idx].setIcon(icon);
					}
					else {
						mat[r][c]=3;
						icon.setImage(ImageIO.read(new File("src/chess/WH.png")));
						bvec[idx].setIcon(icon);
					}
				}
				if((idx==2) || (idx==5) || (idx==58) || (idx==61)) {
					if(idx<40) {
						mat[r][c]=-2;
						icon.setImage(ImageIO.read(new File("src/chess/BB.png")));
						bvec[idx].setIcon(icon);
					}
					else {
						mat[r][c]=2;
						icon.setImage(ImageIO.read(new File("src/chess/WB.png")));
						bvec[idx].setIcon(icon);
					}
				}
				if((idx==0) || (idx==7) || (idx==56) || (idx==63)) {
					if(idx<40) {
						mat[r][c]=-4;
						icon.setImage(ImageIO.read(new File("src/chess/BR.png")));
						bvec[idx].setIcon(icon);
					}
					else {
						mat[r][c]=4;
						icon.setImage(ImageIO.read(new File("src/chess/WR.png")));
						bvec[idx].setIcon(icon);
					}
				}
				if((r==1) || (r==6)) {
					if(idx<40) {
						mat[r][c]=-1;
						icon.setImage(ImageIO.read(new File("src/chess/BP.png")));
						bvec[idx].setIcon(icon);
					}
					else {
						mat[r][c]=1;
						icon.setImage(ImageIO.read(new File("src/chess/WP.png")));
						bvec[idx].setIcon(icon);
					}
				}
				if((idx==4) || (idx==60)) {
					if(idx<40) {
						mat[r][c]=-6;
						icon.setImage(ImageIO.read(new File("src/chess/BK.png")));
						bvec[idx].setIcon(icon);
					}
					else {
						mat[r][c]=6;
						icon.setImage(ImageIO.read(new File("src/chess/WK.png")));
						bvec[idx].setIcon(icon);
					}
				}
				if((idx==3) || (idx==59)) {
					if(idx<40) {
						mat[r][c]=-5;
						icon.setImage(ImageIO.read(new File("src/chess/BQ.png")));
						bvec[idx].setIcon(icon);
					}
					else {
						mat[r][c]=5;
						icon.setImage(ImageIO.read(new File("src/chess/WQ.png")));
						bvec[idx].setIcon(icon);
					}
				}
			}
		}
	}
	
}
