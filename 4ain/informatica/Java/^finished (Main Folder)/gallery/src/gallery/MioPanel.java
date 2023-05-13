package gallery;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MioPanel extends JPanel{
	boolean canimage;
	public MioPanel() {
		setBackground(Color.pink);
		canimage=false;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(canimage) {
			File[] fileList = new File("src/gallery/images/").listFiles();
	        for(int i=0;i<3;i++) {
				for(int j=0;j<5;j++) {
					try {
						Image img=ImageIO.read(fileList[i*5+j]);
						Image resized= img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
						g.drawImage(resized, j*400+50, i*300+50, null);
					} catch (Exception e) {
						
					}
					
				}
			}
		}
	}
	
}