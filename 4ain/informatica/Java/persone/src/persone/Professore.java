package persone;

public class Professore extends Persona{
	private int stipendio;
	private String materia;
	
	public Professore(String nome,String ddn, int numtel,String email,int stipendio,String materia) {
		super(nome,ddn,numtel,email);
		this.stipendio = stipendio;
		this.materia = materia;
	}
	
	public void interroga() {
		stipendio+=1;
		System.out.println("Professore ha interrogato, stipendio aumentato di 1");
	}
}
