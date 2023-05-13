package gallery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MioFrame extends JFrame{
	public MioFrame() {
		setTitle("gallery");
		setDefaultCloseOperation(3);
		setSize(1920,1080);
		//setLayout(null);
		//getContentPane().setBackground(Color.pink);
		MioPanel p= new MioPanel();
		p.setBounds(0, 0, getWidth(), getHeight());
		add(p,BorderLayout.CENTER);
		JButton bt= new JButton();
		bt.setFont(new Font("", Font.ITALIC, 50));
		bt.setText("load");
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				p.canimage=!p.canimage;
				p.repaint();
			}
		});
		add(bt,BorderLayout.SOUTH);
		bt.setPreferredSize(new Dimension(getWidth(),100));
		
		setVisible(true);
	}
}
