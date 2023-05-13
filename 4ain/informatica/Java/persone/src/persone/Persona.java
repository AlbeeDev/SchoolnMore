package persone;

public class Persona {
	private String nome;
	private String ddn;
	private int numtel;
	private String email;
	
	public Persona(String nome,String ddn, int numtel,String email) {
		this.nome=nome;
		this.ddn=ddn;
		this.numtel=numtel;
		this.email=email;
	}
	
	public int getEta(String ddn) {
		int age = Integer.parseInt(ddn);
		return 2022-age;
	}
/*
	@Override
	public String toString() {
		return "Nome: "+ nome +" et�: "+getEta(ddn)+" numero di telefono: "+numtel+" Email: "+email;
	}
	
*/	
}