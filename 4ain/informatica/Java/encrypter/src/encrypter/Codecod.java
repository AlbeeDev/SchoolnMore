package encrypter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class Codecod extends JPanel{
	
	JFrame frame = new JFrame();
	JButton cod = new JButton();
	JButton decod = new JButton();
	JButton filebut = new JButton();
	JTextArea ta = new JTextArea();
	JTextArea ta2 = new JTextArea();
	JTextField[] tf = new JTextField[2];
	JFileChooser fc = new JFileChooser();
	boolean ba = true;
	
	public Codecod() {
		setLayout(null);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(3);
		setBackground(Color.pink);
		frame.add(this);
		cod.setBounds(0,0,300,100);
		cod.setText("Codifica");
		cod.setBackground(Color.lightGray);
		add(cod);
		decod.setBounds(300,0,300,100);
		decod.setText("Decodifica");
		decod.setBackground(Color.lightGray);
		add(decod);
		ta.setBounds(0,120,390,300);
		ta.setLineWrap(true);
		add(ta);
		ta2.setBounds(410,120,370,300);
		ta2.setLineWrap(true);
		ta2.setEditable(false);
		ta2.setBackground(Color.white);
		add(ta2);
		
		filebut.setBounds(600,0,180,100);
		filebut.setBackground(Color.orange);
		filebut.setText("Apri File");
		add(filebut);
		for(int i=0;i<2;i++) {
			tf[i] = new JTextField();
			if(i==0) {
				JLabel l1=new JLabel();
				l1.setText("M:");
				l1.setFont(new Font("",Font.PLAIN,20));
				l1.setBounds(100*(i+1)+(i*300)-50,430,100,100);
				add(l1);
			}
			else {
				JLabel l2=new JLabel();
				l2.setText("Q:");
				l2.setFont(new Font("",Font.PLAIN,20));
				l2.setBounds(100*(i+1)+(i*300)-50,430,100,100);
				add(l2);
			}
			tf[i].setBounds(100*(i+1)+(i*300),460,200,50);
			add(tf[i]);
		}
		frame.setVisible(true);
		
		ActionListener codif = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String str = ta.getText().toUpperCase();
					int m= Integer.parseInt(tf[0].getText());
					int q= Integer.parseInt(tf[1].getText());
					String cryptedstring = encrypt(str,m,q);
					ta2.setText("");
					ta2.append(cryptedstring);
				} catch (Exception e2) {
					System.out.println("error");
				}
				
				
			}
		};
		
		cod.addActionListener(codif);
		
		ActionListener decodif = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String str = ta.getText().toUpperCase();
					int m= Integer.parseInt(tf[0].getText());
					int q= Integer.parseInt(tf[1].getText());
					String decryptedstring = decrypt(str,m,q);
					ta2.setText("");
					ta2.append(decryptedstring);
				} catch (Exception e2) {
					System.out.println("error");
				}
				
				
			}
		};
		
		decod.addActionListener(decodif);
		
		ActionListener filer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileFilter filter = new FileNameExtensionFilter("Text Files","txt");
				fc.setFileFilter(filter);
				
				int result = fc.showOpenDialog(new JFrame());
				if(result == JFileChooser.APPROVE_OPTION) {
					File inputf = fc.getSelectedFile();
					try (BufferedReader br = new BufferedReader(new FileReader(inputf))){
						String str = new String();
						while((str=br.readLine())!=null) {
							ta.setText("");
							ta.append(str);
							
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		};
		
		filebut.addActionListener(filer);
	}
	
	public String encrypt(String str,int m,int q) {
		
		byte[] bit = new byte[str.length()];
		int cont=0;
		for(byte b:str.getBytes()) {
			System.out.println(b);
			if(b>=65 && b<=90) {
				bit[cont++] = (byte) ((((b-65)*m+q)%26)+65);
			}
			else {
				bit[cont++] = b;
			}
			
		}
		return new String(bit);
		
	}
	
	public int getinverse(int m,int mod) {
		for(int i=0;i<mod;i++) {
			if((m*i)%mod==1) return i;
		}
		return -1;
	}
	
	public String decrypt(String str,int m,int q) {
		
		int minv=getinverse(m, 26);
		
		byte[] bit = new byte[str.length()];
		int cont=0;
		for(byte b:str.getBytes()) {
			System.out.println(b);
			if(b>=65 && b<=90) {
				bit[cont++] = (byte) (((((b-65)-q+26)*minv)%26)+65);
			}
			else {
				bit[cont++] = b;
			}
			
		}
		return new String(bit);
		
	}
	
}