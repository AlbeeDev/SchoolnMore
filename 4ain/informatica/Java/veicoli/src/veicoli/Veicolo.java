package veicoli;


abstract public class Veicolo {
	private int nRuote;
	private int nPosti;
	private boolean moving = false;
	
	public Veicolo(int nRuote, int nPosti) {
		this.nRuote = nRuote;
		this.nPosti = nPosti;
	}
	
	public int getnRuote() {
		return nRuote;
	}

	public int getnPosti() {
		return nPosti;
	}

	public boolean isMoving() {
		return moving;
	}
	abstract boolean suona();
	public void move() {
		moving = true;
	}
	@Override
	public String toString() {
		if(isMoving())
			return getClass().getName()+" Numero ruote: " + getnRuote() + ", Numero Posti: " + getnPosti() +
					" Si sta muovendo? Si";
		else
			return getClass().getName()+" Numero ruote: " + getnRuote() + ", Numero Posti: " + getnPosti() + 
					" Si sta muovendo? No";
	}
}

