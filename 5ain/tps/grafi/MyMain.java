package grafi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * controls
 * left click: add node/connect node (arc)
 * right click: remove node/ remove arc
 * middle click: cycle colors
 */

public class MyMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setResizable(false);
		
		
		miopanel panel = new miopanel();
		frame.add(panel);
		
		frame.setVisible(true);

	}

}

class miopanel extends JPanel{
	Grafo gr;
	boolean connecting=false;
	int[] connectpoint=new int[2];
	Nodo connectingnode;
	int dim=100;
	public miopanel() {
		setBackground(Color.pink);
		
		gr = new Grafo();
		
		MouseListener ml = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int buttonClicked = e.getButton();
				Nodo clickedNode = null;
				
		        for (Nodo n : gr.getlistanodi()) {
		            if (n.area.contains(e.getX(), e.getY())) {
		                clickedNode = n;
		                break;
		            }
		        }

		        if (connecting) {
		            if (clickedNode != null) {
		            	if(buttonClicked == MouseEvent.BUTTON1) {
		            		if(!clickedNode.nodiconnessi.keySet().contains(connectingnode.letter)) {
		            			String userInput = JOptionPane.showInputDialog("Enter the arc weight:");
		            			if(userInput!=null) {
									try {
										gr.addarc(clickedNode, connectingnode, Integer.parseInt(userInput));
										gr.printconnections();
									} catch (Exception e1) {}
		            				
		            			}
		            			
		            		}   
		            	}
		            	
		            	else if(buttonClicked == MouseEvent.BUTTON3) {
		            		gr.removearc(clickedNode, connectingnode);
		            	}
		            }
		            connecting = false;
		        } else if (clickedNode == null) {
		        	if(buttonClicked == MouseEvent.BUTTON1) {
		        		gr.addnode(new Nodo(e.getX(), e.getY(), gr.getfirstletter()));
		        	}
		        } else {
		        	if(buttonClicked == MouseEvent.BUTTON1) {
		        		connecting = true;
			            connectpoint = new int[] { clickedNode.x, clickedNode.y };
			            connectingnode = clickedNode;
		        	}
		        	else if(buttonClicked == MouseEvent.BUTTON2) {
		        		clickedNode.cyclecolor();
		        	}
		        	else if(buttonClicked == MouseEvent.BUTTON3) {
		        		gr.removenode(clickedNode);
		        	}
		        	
		        }
		        
		        
				
			}
		};
		
		addMouseListener(ml);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("", Font.BOLD, 30));
		
		
		for(Nodo n : gr.getlistanodi()) {
			g.setColor(n.color);
			g.fillOval(n.x-dim/2, n.y-dim/2, dim, dim);
			g.setColor(Color.black);
			g.drawString(n.letter, n.x-10, n.y+10);
			for(String arc : n.nodiconnessi.keySet()) {
				for(Nodo n2 : gr.getlistanodi()) {
					if(n2.letter.equals(arc)) {
						g.drawLine(n.x, n.y, n2.x, n2.y);
						g.drawString(n.nodiconnessi.get(n2.letter)+"",n.x+(n2.x-n.x)/2,n.y+(n2.y-n.y)/2);
					}
				}
			}
			
		}
		
		if(connecting) {
			Point mouse = MouseInfo.getPointerInfo().getLocation();
			g.drawLine(connectpoint[0],connectpoint[1],mouse.x,mouse.y-25);
		}
		
		repaint();
	}
	
	
}

class Nodo{
	int x,y;
	String letter;
	Color color = Color.LIGHT_GRAY;
	Rectangle area = new Rectangle();
	HashMap<String, Integer> nodiconnessi= new HashMap<String, Integer>();
	int dim=100;
	public Nodo(int x, int y, String letter) {
		this.x=x;
		this.y=y;
		this.letter=letter;
		area.setBounds(x-dim/2, y-dim/2, dim, dim);
	}
	
	public void cyclecolor() {
		if(color.equals(color.lightGray)) color=Color.red;
		else if(color.equals(color.red)) color=Color.green;
		else if(color.equals(color.green)) color=Color.lightGray;
	}
}

class Grafo{
	private ArrayList<Nodo> listanodi;
	String[] alpha = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	public Grafo() {
		listanodi = new ArrayList<Nodo>();
	}
	
	ArrayList<Nodo> getlistanodi(){
		return listanodi;
	}
	
	void addnode(Nodo n) {
		listanodi.add(n);
	}
	
	void removenode(Nodo n) {
		listanodi.remove(n);
		for(Nodo n2 : listanodi){
			try {
				n2.nodiconnessi.remove(n.letter);
			} catch (Exception e) {}
		}
	}
	
	void addarc(Nodo n1, Nodo n2, int weight) {
		n1.nodiconnessi.put(n2.letter, weight);
        n2.nodiconnessi.put(n1.letter, weight);
	}
	
	void removearc(Nodo n1, Nodo n2) {
		n1.nodiconnessi.remove(n2.letter);
		n2.nodiconnessi.remove(n1.letter);
	}

	String getfirstletter(){
		boolean found;
		for(String s : alpha){
			found=true;
			for (Nodo n : listanodi) {
				if(n.letter.equals(s)) {
					found = false;
					break;
				}
			}
			if(found) return s;
		}
		return "err";
	}

	void printconnections(){
		System.out.println("-----------------------");
		for (Nodo n : getlistanodi()) {
			System.out.println("\nnodo "+n.letter+" è connesso a:");
			for(String n2 : n.nodiconnessi.keySet()) {
				System.out.println("nodo " + n2 + " con peso: "+ n.nodiconnessi.get(n2));
			}
		}
	}
}