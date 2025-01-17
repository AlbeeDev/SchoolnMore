package it.corso.eccezioni;

public class MiaEccezione extends RuntimeException {

	private static final long serialVersionUID = 6400444501652480469L;
	
	// attributo di istanza
	private String messaggio;

	// costruttore completo
	public MiaEccezione(String messaggio) {
		this.messaggio = messaggio;
	}

	// getter e setter attributi di istanza
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
}