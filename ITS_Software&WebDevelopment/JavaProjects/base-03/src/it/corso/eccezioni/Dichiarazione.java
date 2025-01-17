package it.corso.eccezioni;
import java.io.FileReader;
import java.io.IOException;

public class Dichiarazione {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Inizio Programma");
		
		somma("2", "ciao");
		leggiFile();
		lanciaEccezione();
		
		System.out.println("Fine Programma");
	}
	
	static void somma(String a, String b) throws NumberFormatException {
		int risultato = Integer.parseInt(a) + Integer.parseInt(b);
		System.out.println(risultato);
	}
	
	static void leggiFile() throws IOException {
		FileReader reader = new FileReader("file.txt");
		reader.read();
		reader.close();
	}
	
	static void lanciaEccezione() {
		throw new RuntimeException("Aiutooooooooo");
	}
}