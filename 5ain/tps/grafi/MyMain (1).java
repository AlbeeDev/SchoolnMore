package grafi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

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
		setLayout(null);
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
		            		if(!clickedNode.nodiconnessi.keySet().contains(connectingnode)) {
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
		
		JButton button = new JButton("Calcola");

        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setBounds(10,10,200,100);;
		button.setFont(new Font("",Font.BOLD,20));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Your action code here
				Dijksrtra djk = new Dijksrtra(gr);
				ArrayList<Nodo> nlist = djk.getshortestpath();
				StringBuilder sb = new StringBuilder();
				for(Nodo n : nlist){
					sb.append(n.letter+" ");
				}
				System.out.println("shortest path: "+sb.toString());
                JOptionPane.showMessageDialog(null, "shortest path: "+sb.toString()+" total distance: "+nlist.get(0).distance);
            }
        });

		add(button);
		
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
			for(Nodo sr : n.nodiconnessi.keySet()) {
				for(Nodo n2 : gr.getlistanodi()) {
					if(n2.letter.equals(sr.letter)) {
						g.drawLine(n.x, n.y, n2.x, n2.y);
						g.drawString(n.nodiconnessi.get(n2)+"",n.x+(n2.x-n.x)/2,n.y+(n2.y-n.y)/2);
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
	HashMap<Nodo, Integer> nodiconnessi= new HashMap<Nodo, Integer>();
	Nodo prev = null;
	Boolean visited = false;
	int distance = 0;
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

class Dijksrtra{
	Grafo gr;
	Dijksrtra(Grafo gr){
		this.gr=gr;
		
	}

	public ArrayList<Nodo> getshortestpath(){

		ArrayList<Nodo> result = new ArrayList<Nodo>();
		Nodo ns=null;
		Nodo nf=null;
		for(Nodo nt : gr.getlistanodi()){
			if(nt.color==Color.green) ns=nt;
			if(nt.color==Color.red) nf=nt;
		}
		exec(ns);
		Nodo nt=nf;
		while(nt!=null){
			result.add(nt);
			nt=nt.prev;
		}
		return result;
	}

	void exec(Nodo n){
		if(n.color.equals(Color.red)){
			return;
		}
		int idx=0;
		for(Nodo n2 : n.nodiconnessi.keySet()){
			
			if((n2.prev==null || n.distance+n.nodiconnessi.get(n2)<n2.distance) && !n2.visited){
				n2.prev=n;
				n2.distance=n.distance+n.nodiconnessi.get(n2);
				System.out.println("new previous of "+n2.letter+" is "+n.letter+" new distance "+n2.distance);
			}
			
			//se n2 è l ultimo elemento dell keyset allora visited true prima di exec
			if(idx>=n.nodiconnessi.keySet().size()) n.visited=true;

			if(!n2.visited) exec(n2);
		}
		return;
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
				n2.nodiconnessi.remove(n);
			} catch (Exception e) {}
		}
	}
	
	void addarc(Nodo n1, Nodo n2, int weight) {
		n1.nodiconnessi.put(n2, weight);
        n2.nodiconnessi.put(n1, weight);
	}
	
	void removearc(Nodo n1, Nodo n2) {
		n1.nodiconnessi.remove(n2);
		n2.nodiconnessi.remove(n1);
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
			for(Nodo n2 : n.nodiconnessi.keySet()) {
				System.out.println("nodo " + n2.letter + " con peso: "+ n.nodiconnessi.get(n2));
			}
		}
	}
}