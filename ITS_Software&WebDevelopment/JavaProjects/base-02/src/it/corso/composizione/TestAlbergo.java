package it.corso.composizione;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestAlbergo {
	
	public static void main(String[] args) {
		// dichiarazione e istanziazione oggetto Camera
		Camera camera = new Camera(103, 89.5);
		// invocazione metodo prenotazione
		creazionePrenotazione(camera);
	}
	
	static void creazionePrenotazione(Camera camera) {
		// acquisizione dati in input
		String nomeCliente = "Mario";
		String cognomeCliente = "Rossi";
		String dataArrivo = "27-11-2024";
		String dataPartenza = "30-11-2024";
		
		// dichiarazione e istanziazione oggetto Cliente
		Cliente cliente = new Cliente(nomeCliente, cognomeCliente);
		
		// dichiarazione e istanziazione oggetto Prenotazione
		Prenotazione prenotazione = new Prenotazione(
				LocalDate.parse(dataArrivo, DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
				LocalDate.parse(dataPartenza, DateTimeFormatter.ofPattern("dd-MM-yyyy")), 
				cliente, 
				camera);
		
		// stampa prenotazione creata
		System.out.println(prenotazione);
	}
}