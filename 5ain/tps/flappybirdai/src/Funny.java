import java.awt.Color;
//import java.awt.Component; //import these 3 header files
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.google.gson.Gson;

//@SuppressWarnings("unused")
public class Funny {

	JFrame frame = new JFrame("vola");
	BirdPanel panelo;

	boolean paused = true;
	boolean tutorialIsOn = true;
	boolean wasresized = false;
	Layer[] mostDurableResult;
	Timer time;
	boolean isGameplayEnabled = false;
	boolean looping = false;

	public Funny() {
		frame.setBounds(30, 30, Costants.larghezzaFrame, Costants.altezzaFrame);
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);

		frame.setBackground(Color.ORANGE);
		panelo = new BirdPanel(frame);

		frame.add(panelo.getpanel());
		panelo.settutorial(tutorialIsOn);
		panelo.repaint();

		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent evnt) {
				// Component comp = (Component) evnt.getComponent();
				wasresized = true;
			}
		});

		/*
		 * JOptionPane option = new JOptionPane(); //un tentativo di fare una finestra
		 * pop up (senza successo) option.setFocusable(true); option.setBounds(100, 100,
		 * 700, 300); option.setMessage("bud"); option.setEnabled(true);
		 * option.setMessageType(3); JOptionPane.setRootFrame(frame); frame.add(option);
		 * option.setVisible(true);
		 */

		KeyListener listening = new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) { // il lettore degli input da tastira
				switch (e.getKeyCode()) {
				// abilitare il gameplay quando non è solo intelligenza artificiale
				// TODO fare in modo da poter giocare quando questa variabile è true
				case KeyEvent.VK_SPACE: {
					if (isGameplayEnabled)
						if (!paused && panelo.keepGoing()) // ci si puo muovere solo se non è in pausa
							panelo.flap.flap();
					break;
				}
				case KeyEvent.VK_UP: {
					if (isGameplayEnabled)
						if (!paused && panelo.keepGoing()) // ci si puo muovere solo se non è in pausa
							panelo.flap.flap();
					break;
				}
				case KeyEvent.VK_F1: { // attiva/disattiva la modalità loop with no stops
					looping = !looping;
					break;
				}
				case KeyEvent.VK_F2: {
					uploadResultMatrix();
					break;
				}
				case KeyEvent.VK_F3: {
					downloadResultMatrix();
					break;
				}
				case KeyEvent.VK_F4: {
					emptyHall();
					break;
				}
				case KeyEvent.VK_P: {
					if (!paused) { // segna se è in pausa così non si possono muovere gli oggetti
						time.stop(); // se non è in pausa lo metto in pausa
						paused = !paused; // segno di aver messo in pausa
						// TODO trasformare questa uscita da syso a una stringa di testo sullo schermo
						for (int i = 0; i < panelo.flappys.length; i++)
							System.out.println("Punteggio Attuale: " + panelo.flappys[i].pointScore);
					} else if (panelo.keepGoing()) { // riparte il timer solo se il player sta ancora giocando
						time.start();
						paused = !paused;
					}
					if (tutorialIsOn) {
						tutorialIsOn = false; // se il tutorial è aperto lo chiudo
						panelo.settutorial(tutorialIsOn);
						panelo.repaint();
					}
					break;
				}
				case KeyEvent.VK_ESCAPE: {
					for (int i = 0; i < panelo.flappys.length; i++)
						System.out.println("I punti al momento della chiusura sono: " + panelo.flappys[i].pointScore);
					frame.dispose();
// chiude il frame e tutto cio che ne deriva (trovato prima botta lets go)
				}
				case KeyEvent.VK_R: {
					panelo.refresh();
					paused = true;
					for (int i = 0; i < panelo.flappys.length; i++)
						panelo.flappys[i].pointScore = 0;
					panelo.settutorial(tutorialIsOn = true);
					time.restart();
					time.stop();
					panelo.repaint();
					break;
				}
				case KeyEvent.VK_BACK_SLASH: {
					for (int i = 0; i < mostDurableResult.length; i++)
						System.out.println((i + 1) + "° Strato: " + mostDurableResult[i]);
				}
				default:
					if (!paused) { // se sbaglio il pulsante metto in pausa
						time.stop(); // se non è in pausa lo metto in pausa
						paused = !paused; // segno di aver messo in pausa
					}
					if (!tutorialIsOn) {
						tutorialIsOn = true; // e mostro lo schema dei pulsanti
						panelo.settutorial(tutorialIsOn);
						panelo.repaint();
					}
					// nel caso in cui sbagli a premere mette in pausa
					// e mostra la lista dei comandi
				}
			}
		};
		frame.addKeyListener(listening);

		panelo.flap.generateBrain();
// mi segno il primo cervello come migliore così da poterlo usare per evolvermi
		mostDurableResult = panelo.flap.smart.gangli;
		ActionListener nami = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // le azioni che scattano alla fine di un refresh
				for (int i = 0; i < panelo.flappys.length; i++) {
					if (panelo.flappys[i].alive) {
						panelo.flappys[i].accelerate();
						panelo.flappys[i].pointScore++;
					}
				}
				panelo.generate();
				panelo.checkAliveBirds();
				if (wasresized)
					adaptConsts();
				if (!panelo.keepGoing()) {
					time.stop();
					if (!looping)
						panelo.settutorial(tutorialIsOn = true);
					Pipe k = panelo.getClosestPipe();
					for (int i = 0; i < panelo.flappys.length; i++) {
						panelo.flappys[i].pointScore = panelo.flappys[i].pointScore
								- Math.abs(panelo.flappys[i].y + panelo.flappys[i].height / 2 - k.y + k.distance / 2)
										/ 20;
//il mio punteggio dovrebbe aumentare più sono vicino 
// al centro del tubo da superare.
//questo perchè ho scritto una operazione che diminuisce il punteggio 
// a seconda della distanza in entrambe le direzioni della y 
// del centro del bird dalla y del centro del tubo più vicino
						if (panelo.flappys[i].printable) {
							System.out.println("Punteggio Finale: " + panelo.flappys[i].pointScore);
							panelo.flappys[i].printable = false;
						}
						// TODO trasformare questa uscita da syso a una stringa di testo sullo schermo
						if (panelo.flappys[i].pointScore > panelo.bestScore) {
							panelo.bestScore = panelo.flappys[i].pointScore;
							mostDurableResult = panelo.flappys[i].smart.gangli;
							hallOfFame(panelo.bestScore);
						}
						for (int j = 0; j < panelo.flappys[i].smart.gangli.length; j++) {
							panelo.flappys[i].smart.evolve(panelo.flappys[i].smart.gangli[j].mat, j);
						}
					}
					System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
					if (looping) {
						loop();
					}
				}
				panelo.repaint();
				// un piccolo salto per l'uccellino un grande passo per il programmatore
				if (!isGameplayEnabled)
					for (int i = 0; i < panelo.flappys.length; i++)
						if (!paused && panelo.keepGoing()
								&& panelo.flappys[i].chooseToJump(panelo.getInputs(panelo.flappys[i])))
							panelo.flappys[i].flap();
			}

		};
		time = new Timer(Costants.timeBetweenFrames, nami);
		if (!paused)
			time.start();
	}

	void adaptConsts() {
		// TODO implementare l'allargamento dei tubi in base alla larghezza dello
		// schermo
		Costants.altezzaFrame = frame.getHeight();
		Costants.larghezzaFrame = frame.getWidth();
		Costants.altezzaSchermo = Costants.altezzaFrame - 50;
		Costants.larghezzaSchermo = Costants.larghezzaFrame - 50;
		Costants.xDiRespawn = Costants.larghezzaFrame - 100;
		wasresized = false;
	}

	void loop() {
		panelo.refresh();
		time.restart();
		time.start();
	}

	void emptyHall() {
		File never = new File("HallOfFame.txt");
		try {
			Writer write = new FileWriter(never);
			write.write("");
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void hallOfFame(int bestScore) {
		File never = new File("HallOfFame.txt");
		try {
			Writer write = new FileWriter(never);
			write.append("record battuto il " + System.currentTimeMillis() + " con un punteggio di:" + bestScore);
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * scrive nel file (TODO mettere come costante nella classe in fondo) i dati dei
	 * neuroni salvati nel cervallo migliore
	 */
	void uploadResultMatrix() {
		File never = new File("SimplyTheBest.txt");
		try {
			Writer write = new FileWriter(never);
			// non ho trovato una funzione per svuotare il file da tutto
			// cio che c'e scritto (questo sembra funzionare quindi no problem)
			write.write("");

			write.append(new Gson().toJson(mostDurableResult));

			write.flush();
			System.out.println("Successfully saved the Bestbrain");
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// legge nel file (TODO mettere come costante nella classe in fondo) TODO da far
	// funzionare
	void downloadResultMatrix() {
		File never = new File("SimplyTheBest.txt");
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(never));
			String line = "";
			String alliner = "";
			while ((line = buffer.readLine()) != null) {
				alliner += line;
			}
			System.out.println(alliner);

			mostDurableResult = new Gson().fromJson(alliner, Layer[].class);
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class BirdPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// TODO trasformare queste classi in file .java con il nome (appena finito)

	private final int numbpipe = 4; // numero di tubi in gioco
	boolean tutorial = false;
	Image buttonTutorial;
	int bestScore;
	Bird flap = new Bird();
	Bird[] flappys = new Bird[Costants.numBirdToSpawn];
	Pipe[] tube = new Pipe[numbpipe];

	public BirdPanel(JFrame frame) {
		this.setBackground(Color.DARK_GRAY);
		this.setBounds(frame.getContentPane().getBounds());
		this.setVisible(true);
		for (int i = 0; i < flappys.length; i++) {
			flappys[i] = new Bird();
			flappys[i].generateBrain();
			flappys[i].pointScore = 0;
		}
		initializeArray();
		flap.pointScore = 0;
		bestScore = 0;
		try {
			buttonTutorial = ImageIO.read(new File("keys_withtext_transparent.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}

	void initializeArray() {
		Random randy = new Random();
		for (int i = 0; i < numbpipe; i++) {
			tube[i] = new Pipe();
		}
		for (int i = 0; i < numbpipe; i++) {
//			int temp = randy.nextInt(50) + 145; // Constants.larghezzaSchermo / numbpipe * (i + 1)
			for (int j = 0; j < flappys.length; j++)
				tube[i].setCoords(
						tube[(i + tube.length - 1) % tube.length].x + Costants.larghezzaSchermo / numbpipe * 5 / 4
								+ flappys[j].x,
						randy.nextInt(Costants.altezzaSchermo - Costants.distanzaTubiDefault * 2)
								+ Costants.distanzaTubiDefault / 2,
						Costants.larghezzaTubo, Costants.distanzaTubiDefault);
		}
	}

	boolean haveAnyCollided() {
		for (int i = 0; i < flappys.length; i++) {
			if (!flappys[i].hasBonked())
				return true;
			// prendo il prossimo tubo e me lo salvo in modo da non dover
			// controllarli tutti ogni volta
			Pipe nexTube = getClosestPipe();
			// controllo se il mio bird è nel mezzo del prossimo tubo
			// questo metodo lascia scoperta la possibilità in cui il bird è
			// più largo/piccolo del tubo visto che controllo solo sinistra abs.
			// centro e destra abs.
			if ((flappys[i].x < nexTube.x + nexTube.width && flappys[i].x > nexTube.x)
					|| (flappys[i].x + flappys[i].width < nexTube.x + nexTube.width
							&& flappys[i].x + flappys[i].width > nexTube.x)
					|| (flappys[i].x + flappys[i].width < nexTube.x + nexTube.width / 2
							&& flappys[i].x + flappys[i].width / 2 > nexTube.x)) {
				// controllo se la y del bird è superiore alla y del tubo
				// (cioè la y del lato in basso del rettengolo sopra) o minore
				// della y + la distanza (cioè la y del lato in alto del rettengolo sotto)
				if (flappys[i].y < nexTube.y || flappys[i].y + flappys[i].height > nexTube.y + nexTube.distance) {
					return true;
				}
			}
		}
		return false;
	}

	boolean hasCollided(Bird hawk) {
		if (!hawk.hasBonked())
			return true;
		// prendo il prossimo tubo e me lo salvo in modo da non dover
		// controllarli tutti ogni volta
		Pipe nexTube = getClosestPipe();
		// controllo se il mio bird è nel mezzo del prossimo tubo
		// questo metodo lascia scoperta la possibilità in cui il bird è
		// più largo/piccolo del tubo visto che controllo solo sinistra abs.
		// centro e destra abs.
		if ((hawk.x < nexTube.x + nexTube.width && hawk.x > nexTube.x)
				|| (hawk.x + hawk.width < nexTube.x + nexTube.width && hawk.x + hawk.width > nexTube.x)
				|| (hawk.x + hawk.width < nexTube.x + nexTube.width / 2 && hawk.x + hawk.width / 2 > nexTube.x)) {
			// controllo se la y del bird è superiore alla y del tubo
			// (cioè la y del lato in basso del rettengolo sopra) o minore
			// della y + la distanza (cioè la y del lato in alto del rettengolo sotto)
			if (hawk.y < nexTube.y || hawk.y + hawk.height > nexTube.y + nexTube.distance) {
				return true;

			}
		}
		return false;
	}

	Bird getBird(int numeros) {
		return flappys[numeros];
	}

	void checkAliveBirds() {
		for (int i = 0; i < flappys.length; i++) {
			if (hasCollided(flappys[i]))
				flappys[i].alive = false;
		}
	}

	boolean keepGoing() {
		for (int i = 0; i < flappys.length; i++) {
			if (flappys[i].alive)
				return true;
		}
		return false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.PINK);
		for (int i = 0; i < flappys.length; i++)
			if (flappys[i].alive)
				g.drawRect(flappys[i].x, flappys[i].y, flappys[i].width, flappys[i].height);
		g.setColor(Color.GREEN);

		for (int i = 0; i < numbpipe; i++) {
			g.drawRect(tube[i].getUpperRect().x, tube[i].getUpperRect().y, tube[i].getUpperRect().width,
					tube[i].getUpperRect().height);
			g.drawRect(tube[i].getLowerRect().x, tube[i].getLowerRect().y, tube[i].getLowerRect().width,
					tube[i].getLowerRect().height);
		}
		if (tutorial) {
			g.drawImage(buttonTutorial, this.getWidth() / 2 - buttonTutorial.getWidth(null) / 2,
					this.getHeight() / 2 - buttonTutorial.getHeight(null) / 2, null);
		}
	}

	void generate() {
		Random randy = new Random();
		if (tube.length == 1) {
			tube[0].setCoords(Costants.xDiRespawn, randy.nextInt(420) + 150, Costants.larghezzaTubo,
					randy.nextInt(50) + 145);
			tube[0].x -= tube[0].vx;
			return;
		}
		for (int i = 0; i < tube.length; i++) {
			if (!tube[i].isOnScreen()) {
				int temp;
				// mi segno il numero del indice precedente per chiarezza
				int indicePrima = (i + tube.length - 1) % tube.length;
				// fa in modo di gestire la x del tubo
				tube[i].x = tube[indicePrima].x + Costants.larghezzaSchermo / numbpipe * 5 / 4;
				// fa in modo da gestire la y del tubo
				do {
					temp = tube[indicePrima].y
							+ (randy.nextBoolean() ? 40 + randy.nextInt(150) : -40 - randy.nextInt(150));
				} while (temp < Costants.distanzaTubiDefault
						|| temp > Costants.altezzaSchermo - Costants.distanzaTubiDefault);
				// randomizzo in un range vicino al tubo precedente
				tube[i].y = temp;
				tube[i].distance = Costants.distanzaTubiDefault;
			}
			tube[i].x -= tube[i].vx;
		}
	}

	void refresh() {
		Random randy = new Random();
//		int temp = randy.nextInt(50) + 145; // Constants.larghezzaSchermo / numbpipe * (i + 1)
		for (int i = 0; i < flappys.length; i++) {
			flappys[i].y = 300;
			flappys[i].vy = -15;
			flappys[i].alive = true;
			flappys[i].printable = true;
			flappys[i].pointScore = 0;
		}
		tube[numbpipe - 1] = new Pipe(); // riassegno il l'ultimo tubo in modo che il primo si riaddatti da se
		for (int i = 0; i < numbpipe; i++) {
//			temp = randy.nextInt(50) + 145; // Constants.larghezzaSchermo / numbpipe * (i + 1)
			for (int j = 0; j < flappys.length; j++)
				tube[i].setCoords(
						tube[(i + tube.length - 1) % tube.length].x + Costants.larghezzaSchermo / numbpipe * 5 / 4
								+ flappys[j].x,
						randy.nextInt(Costants.altezzaSchermo - Costants.distanzaTubiDefault * 2)
								+ Costants.distanzaTubiDefault / 2,
						Costants.larghezzaTubo, Costants.distanzaTubiDefault);
		}
	}

	double[] getInputs(Bird flapper) {
//		Pipe k = getClosestPipe(flapper);
		Pipe k = getClosestPipe();
		double[] result = new double[3];
		result[0] = (double) (k.x - (flapper.x + flapper.width)) / this.getWidth();
		result[1] = (double) (flapper.y) / this.getHeight();
		result[2] = (double) (k.y + k.distance / 2) / this.getHeight();
//		System.out.println("res0: " + result[0] + "\nres1: " + result[1] + "\nres2: " + result[2]);
		return result;
	}

//	Pipe getClosestPipe() {
//		Pipe k = tube[0];
//		for (int i = 0; i < numbpipe; i++) {
//			k = tube[i].x < k.x ? tube[i] : k;
//		}
//		return k;
//	}

	Pipe getClosestPipe() {
		Pipe k = tube[0];
		for (int i = 0; i < numbpipe; i++) {
			k = (tube[i].x + tube[i].width > Costants.birdDefaultX && tube[i].x < k.x) ? tube[i] : k;
		}
		return k;
	}

	void settutorial(boolean on) {
		tutorial = on;
	}

	BirdPanel getpanel() {
		return this;
	}

}

class Bird {
	int x = Costants.birdDefaultX;
	int y = Costants.birdDefaultY;
	int width = Costants.birdDefaultWidth;
	int height = Costants.birdDefaultHeight;
	int vy = -15;
	int pointScore = 0;
	boolean alive = true;
	boolean printable = true;
//una variabile usata per chiarezza per non vedere 
//i risultati di tutti bird appena ne muore uno

	Brain smart;

	Rectangle getrect() {
		return new Rectangle(x, y, width, height);
	}

	void flap() {
		vy = -Costants.accelerazioneBird; // diminuisco la velocita perche l'origine del frame è in alto a sinistra
//		System.out.println("\n\n\nflap");
	}

	boolean hasBonked() { // TODO da modificare
		if (y < 0 || y + height > Costants.altezzaSchermo)
			return false;
		return true;
	}

	void accelerate() {
		y += vy;
		if (vy < Costants.maxAccelerazione)
			vy += Costants.accelerazioneGravita;
	}

	// genero il cervello di questo uccellino
	void generateBrain() {
		smart = new Brain(Costants.numneuroni, 3);
	}

	boolean chooseToJump(double[] inputs) {
		return (smart.think(inputs) > 0.5);
	}

}

class Pipe {
	int x, y, width, distance; // y è la altezza massima del primo rettangolo
//distance è la distanza tra la y max del primo rettangolo e la y minima del secondo
	int vx = Costants.velocitaTubo; // velocita di spostamento sull' asse x

	public Pipe() {
		x = 0;
		y = 300;
		width = Costants.larghezzaTubo;
		distance = 145;
	}

	public Pipe(int x, int y, int width, int distance) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.distance = distance;
	}

	boolean isInBounds() { // utilizzato per implementare i tubi con dati realistici
		if (y < 0 || y + distance > Costants.altezzaSchermo) {
			return false;
		}
		return true;
	}

	boolean isOnScreen() { // utilizzato per centrare il tubo sullo schermo
		if (x + width < 0) {
			return false;
		}
		return true;
	}

	Rectangle getUpperRect() {
		return new Rectangle(x, 0, width, y);
	}

	Rectangle getLowerRect() {
		return new Rectangle(x, y + distance, width, Costants.altezzaSchermo);
	}

	void setCoords(int x, int y, int width, int distance) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.distance = distance;
	}

	void setVelocity(int velocity) {
		vx = velocity;
	}
}

class Costants {
	static int altezzaFrame = 750;
	static int larghezzaFrame = 950;
	static int altezzaSchermo = altezzaFrame - 50;
	static int larghezzaSchermo = larghezzaFrame - 50;
	static int xDiRespawn = larghezzaFrame - 100;
	static int larghezzaTubo = 75;
	static int distanzaTubiDefault = 180;
	static int velocitaTubo = 8;
	static int birdDefaultX = 65;
	static int birdDefaultY = 300;
	static int birdDefaultWidth = 50;
	static int birdDefaultHeight = 45;
	static int accelerazioneGravita = 4;
	static int maxAccelerazione = 25;
	static int accelerazioneBird = 20; // accelerazione del bird quando batte le ali
// in qualcune caso in cui devo distanziare i tubi dal bordo questa è la distanza

	static int timeBetweenFrames = 40; // millisecondi di intervallo tra frame

	static final int[] numneuroni = { 4, 3, 1 }; // il numero di neuroni da dare al mio cervello
	static final int numBirdToSpawn = 100;
}