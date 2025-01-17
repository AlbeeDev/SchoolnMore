package it.corso.composizione;

public class Cliente {
	
	// attributi di istanza
	private String nome;
	private String cognome;
	
	// costruttore completo
	public Cliente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	// getter e setter
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	// rappresentazione testuale
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + "]";
	}
}