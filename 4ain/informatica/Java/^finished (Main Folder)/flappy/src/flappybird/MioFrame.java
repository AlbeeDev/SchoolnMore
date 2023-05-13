package flappybird;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MioFrame extends JFrame {

public MioFrame() {
		
		setSize(800,600);
		//setSize(1920,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MioPanel panel= new MioPanel();
		panel.setBounds(0, 0, getContentPane().getWidth(), getContentPane().getHeight());
		add(panel);
		setVisible(true);
	}

}