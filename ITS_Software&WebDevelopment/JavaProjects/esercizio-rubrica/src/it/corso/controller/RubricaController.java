package it.corso.controller;
import java.time.LocalDate;
import java.util.Scanner;
import it.corso.model.Address;
import it.corso.model.Contact;
import it.corso.repository.ContactRepository;
import it.corso.repository.ContactRepositoryImpl;

public class RubricaController {
	
	private static Scanner scanner = new Scanner(System.in);
	private static ContactRepository cr = new ContactRepositoryImpl();
	
	public static void main(String[] args) {
		getPannelloComandi();
	}
	
	// pannello comandi dell'applicazione
	static void getPannelloComandi() {
		System.out.println(
				"Cosa vuoi fare?\n" + 
				"N - Nuovo Contatto\n" +
				"R - Rubrica Contatti\n" +
				"E - Esci");
		
		String sceltaUtente = scanner.next();
		
		switch (sceltaUtente.toUpperCase()) {
			case "N":
				creaNuovoContatto();
				getPannelloComandi();
				break;
			case "R":
				stampaRubrica();
				getPannelloComandi();
				break;
			case "E":
				System.out.println("Arrivederci");
				System.exit(0);
				break;
			default:
				System.out.println("Comando non riconosciuto");
				getPannelloComandi();
		}
	}
	
	// creazione nuova fattura e salvataggio nel database
	static void creaNuovoContatto() {
		System.out.println("CREA UN NUOVO CONTATTO");
		try {
			//address
			Address address = new Address();
			System.out.println("Inserisci nome strada");
			address.setStreet(scanner.next());
			System.out.println("Inserisci civico");
			address.setCivic(scanner.next());
			System.out.println("Inserisci cap");
			address.setCap(scanner.next());
			System.out.println("Inserisci citta");
			address.setTown(scanner.next());
			System.out.println("Inserisci provincia");
			address.setProvince(scanner.next());
			//contact
			Contact contact = new Contact();
			System.out.println("Inserisci nome");
			contact.setName(scanner.next());
			System.out.println("Inserisci cognome");
			contact.setLastName(scanner.next());
			contact.setPhoto(null); //per semplicità
			System.out.println("Inserisci numero di telefono");
			contact.setPhone(scanner.next());
			System.out.println("Inserisci email");
			contact.setMail(scanner.next());
			contact.setAddress(address);

			cr.registraContatto(contact,address);
			System.out.println("!CONTATTO REGISTRATO CON SUCCESSO!");
		} catch (Exception e) {
			System.out.println("Valore invalido");
			scanner = new Scanner(System.in);
			creaNuovoContatto();
		}
	}
	
	// stampa in console dell'intero registro recuperato dal database
	static void stampaRubrica() {
		System.out.println("REGISTRO CONTATTI");
		System.out.println("----------------------------------------");
		for (Contact c : cr.elencoContatti()) {
			System.out.println(c);
			System.out.println(c.getAddress());
			System.out.println("----------------------------------------");
		}
	}
}