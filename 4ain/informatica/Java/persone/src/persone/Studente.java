package persone;

public class Studente extends Persona{
	private Integer numStud;
	private Integer mediaScol;
	private String nomElab;
	
	public Studente
	(String nome,String ddn, int numtel,String email,Integer numStud,Integer mediaScol,String nomElab) {
		super(nome,ddn,numtel,email);
		this.numStud = numStud;
		this.mediaScol = mediaScol;
		this.nomElab = nomElab;
	}
	
	public void conegnaElaborato(String nomElab) {
		System.out.println("Elaborato "+nomElab+" consegnato");
	}
	
}
