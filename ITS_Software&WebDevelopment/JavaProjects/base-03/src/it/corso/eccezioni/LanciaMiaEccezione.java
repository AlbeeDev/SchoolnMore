package it.corso.eccezioni;
import java.util.Scanner;

public class LanciaMiaEccezione {
	
	public static void main(String[] args) {
		// dichiarazione e istanziazione oggetto Scanner per recupero input utente
		Scanner scanner = new Scanner(System.in);
		
		// acquisizione input utente
		System.out.println("Digita qualcosa");
		String input = scanner.next();
		scanner.close();
		
		// verifica input
		if(input.length() < 3)
			throw new MiaEccezione("Input troppo corto!!!!");
		
		// output utente
		System.out.println("Hai digitato " + input);
	}
}