package triagrid;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyMain {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1920,1080);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		
		int so=50; //strati verso il basso
		int sv=50; //strati verso destra
		double total=0;
		if(sv==so) {
			total=Math.pow(sv, 2)+(sv-1)*sv/2*sv;
		}
		else if(sv<so) {
			total=Math.pow(so, 2)+((sv*(sv+1)/2-so)*so);
		}
		else if(sv>so) {
			total=so*(sv*(sv+1)/2);
		}
		
		JLabel l = new JLabel();
		l.setBounds(0, 0, 400, 120);
		l.setFont(new Font("",Font.BOLD,30));
		l.setText("<html>"+"Strati verticali: "+sv+"<br>"+"Strati orizzontali: "+so+"<br>"+"N di triangoli: "+total+"</html>");
		f.add(l);
		
		f.setVisible(true);
		
		MioPanel p = new MioPanel(sv,so);
		p.setBounds(0, 0, f.getContentPane().getWidth()-1, f.getContentPane().getHeight()-10);
		f.add(p);
		

	}

}
