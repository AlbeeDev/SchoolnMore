package pallina;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MioFrame extends JFrame {

public MioFrame() {
		
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MioPanel panel= new MioPanel();
		panel.setBounds(0, 0, getContentPane().getWidth(), getContentPane().getHeight());
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new MioFrame();
		
	}

}
