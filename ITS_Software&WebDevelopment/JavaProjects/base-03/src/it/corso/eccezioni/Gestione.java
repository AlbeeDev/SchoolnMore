package it.corso.eccezioni;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Gestione {
	
	public static void main(String[] args) {
		System.out.println("Inizio Programma");
		
		 somma("2", "ciao");
		
		// gestione con blocchi catch separati
		try {
			divisione("7", "0");
		} catch(NumberFormatException e) {
			System.out.println("Input non corretti");
		} catch(ArithmeticException e) {
			System.out.println("Divisione per zero impossibile");
		}
		
		// gestione con multicatch
		try {
			divisione("7", "ciao");
		} catch(NumberFormatException | ArithmeticException e) {
			if(e instanceof NumberFormatException)
				System.out.println("Input non corretti");
			else
				System.out.println("Divisione per zero impossibile");
		}
		
		leggiFile();
		
		try {
			lanciaEccezione();
		} catch (IOException e) {
			System.out.println("Abbiamo lanciato un'eccezione");
		}
		
		System.out.println("Fine Programma");
	}
	
	static void somma(String a, String b) {
		try {
			int risultato = Integer.parseInt(a) + Integer.parseInt(b);
			System.out.println(risultato);
		} catch(NumberFormatException e) {
			System.out.println("I dati in input non sono corretti " + e.getMessage());
		}
	}
	
	static void divisione(String a, String b) {
		int risultato = Integer.parseInt(a) / Integer.parseInt(b);
		System.out.println(risultato);
	}
	
	static void leggiFile() {
		try {
			FileReader reader = new FileReader("file.txt");
			reader.read();
			reader.close();
		} catch(FileNotFoundException e) {
			System.out.println("Il file non esiste");
		} catch(IOException e) {
			System.out.println("Il file è danneggiato");
		}
	}
	
	static void lanciaEccezione() throws IOException {
		throw new IOException();
	}
}