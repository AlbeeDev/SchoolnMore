package calcolatrice;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyMain {

	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(335, 535);
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(164, 232, 74));
		try {
			f.setIconImage(ImageIO.read(new File("src/calcolatrice/icon.png")));
		} catch (Exception e) {
			
		}
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Calcolatrice");
		f.setLayout(null);
		JButton[] bvec = new JButton[24];
		for(int i=5;i>=0;i--) {
			for(int j=3;j>=0;j--) {
				bvec[i*4+j] = new JButton();
				bvec[i*4+j].setFocusable(false);
				bvec[i*4+j].setBounds(322-(j+1)*80,440-(i*55), 75, 50);
				bvec[i*4+j].setBackground(new Color(255,255,255));
				bvec[i*4+j].setFont(new Font("BOLD", Font.BOLD, 20));
				f.add(bvec[i*4+j]);
			}
		}
		setButtons(bvec);
		JPanel p = new JPanel();
		p.setBounds(5, 50, 310, 100);
		p.setBackground(Color.WHITE);
		f.add(p);
		JLabel l = new JLabel();
		l.setBounds(0, 0, 310, 100);
		l.setFont(new Font("BOLD", Font.BOLD, 40));
		l.setText("");
		p.add(l);
		MioAscoltatore al = new MioAscoltatore(l,bvec);
		for(int i=5;i>=0;i--) {
			for(int j=3;j>=0;j--) {
				bvec[i*4+j].addActionListener(al);
			}
		}
		al.enableAll(bvec, false);
		f.setVisible(true);
	}
	
	public static void setButtons(JButton[] bvec) {
		int i=0;
		bvec[i++].setText("=");
		bvec[i++].setText(".");
		bvec[i++].setText("0");
		bvec[i++].setText("+/-");
		bvec[i++].setText("+");
		bvec[i++].setText("3");
		bvec[i++].setText("2");
		bvec[i++].setText("1");
		bvec[i++].setText("-");
		bvec[i++].setText("6");
		bvec[i++].setText("5");
		bvec[i++].setText("4");
		bvec[i++].setText("x");
		bvec[i++].setText("9");
		bvec[i++].setText("8");
		bvec[i++].setText("7");
		bvec[i++].setText("÷");
		bvec[i++].setText("%");
		bvec[i++].setText("2√x");
		bvec[i++].setText("x^y");
		bvec[i++].setText("⌫");
		bvec[i++].setText("C");
		bvec[i++].setText("Ln");
		bvec[i].setText("Log");
	}
}