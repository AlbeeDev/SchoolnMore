package imagegui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;




@SuppressWarnings("serial")
public class MioPanel extends JPanel{
	File[] filelist= new File[4];
	int drawimm=-1;
	public MioPanel() {
		setLayout(null);
		setBackground(Color.pink);
		for(int i=0;i<4;i++) {
			filelist[i]= new File("fiore"+i+".jpg");
		}
		JButton[] button = new JButton[4];
		for(int i=0;i<4;i++) {
			button[i]= new JButton();
			button[i].setBounds(i*100+i*30+10,150, 100, 30);
			Integer k=i+1;
			button[i].setText(k.toString());
			button[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					JButton b= (JButton) e.getSource();
					try {
						drawimm=Integer.parseInt(b.getText())-1;
						repaint();
					} catch (Exception e1) {
						
					}
					
				}
			});
			add(button[i]);
		}
		
		MioGrafico graph = new MioGrafico();
		graph.setBounds(450, 200, 300, 300);
		add(graph);
		
		JButton grb = new JButton();
		grb.setBounds(550,100,200,50);
		grb.setText("grafico di f(x) = f/x");
		grb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				graph.drawg=!graph.drawg;
				graph.repaint();
				
			}
		});
		add(grb);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image imm=null;
		File[] filelist = new File[4];
		for(int i=0;i<filelist.length;i++) {
			filelist[i]= new File("fiore"+i+".jpg");
			try {
				imm= ImageIO.read(filelist[i]);
				imm = imm.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				g.drawImage(imm, i*100+i*30+10, 30, null);
			} catch (IOException e) {
				
			}
			
		}
		Image bigimm=null;
		try {
			if(drawimm!=-1) {
				System.out.println(drawimm);
				bigimm= ImageIO.read(filelist[drawimm]);
				bigimm= bigimm.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
				g.drawImage(bigimm,100,200,null);
			}
			
		} catch (IOException e2) {
			
		}
		
	}

	
}