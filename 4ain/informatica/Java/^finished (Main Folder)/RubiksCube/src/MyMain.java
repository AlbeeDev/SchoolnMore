import javax.swing.JFrame;

public class MyMain {

	public static void main(String[] args) {
		int [][][]mat= new int[6][3][3];
		int t=0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					mat[i][j][k]=t;
				}
			}
			t++;
		}
		JFrame f = new JFrame();
		f.setSize(800,600);
		f.setDefaultCloseOperation(3);
		
		Visualizer visual = new Visualizer(mat);
		visual.setBounds(0, 0, f.getContentPane().getWidth(), f.getContentPane().getHeight());
		
		f.getContentPane().add(visual);
		f.setVisible(true);
	}
}
