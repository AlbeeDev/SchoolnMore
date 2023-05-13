package tris;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain {

	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		frame.setTitle("TRIS");
		frame.setSize(1200,900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//frame.setLayout(null);
		frame.setLayout(new GridLayout(3,3));
		
		int [][]mat= new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				mat[i][j]=0;
			}
		}
		
		
		JButton[] bvec = new JButton[9];
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++) {
				bvec[r*3 + c] = new JButton(); 
				bvec[r*3 + c].setActionCommand(r+" "+c);
				//bvec[r*3 + c].setBounds(400*r, 300*c, 400, 300);
				frame.add(bvec[r*3 + c]);
			}
		}
		
		MioAscoltatore al=new MioAscoltatore(mat,bvec);
		
		for(int r=0;r<3;r++) {
			for(int c=0;c<3;c++) {
				bvec[r*3+c].addActionListener(al);
			}
		}
		
		frame.setVisible(true);
		
	}
	
}