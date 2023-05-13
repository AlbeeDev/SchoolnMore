package veicoli;

public class Automobile extends Veicolo{
	private int serbatoio;
	private int limiteSerbatoio;
	public Automobile(int nRuote, int nPosti) {
		super(nRuote, nPosti);
		serbatoio = 0;
		limiteSerbatoio = 50;
	}
	
	@Override
	boolean suona() {
		return true;
	}

	public int getSerbatoio() {
		return serbatoio;
	}
	public int fill(int litri) {
		if(litri>0) {
			int tempSerbatoio= serbatoio;
			if((serbatoio+litri)>limiteSerbatoio)
				serbatoio=limiteSerbatoio;
			else
				serbatoio = serbatoio + litri;
			return serbatoio - tempSerbatoio;
		}
		else
			return 0;
	}
	@Override
	public String toString() {
		if(isMoving())
			return getClass().getName()+" Numero ruote: " + getnRuote() + ", Numero Posti: " + getnPosti() +
					" Si sta muovendo? Si, " + "Litri: " + getSerbatoio();
		else
			return getClass().getName()+" Numero ruote: " + getnRuote() + ", Numero Posti: " + getnPosti() +
					" Si sta muovendo? No, " + "Litri: " + getSerbatoio();
	}
	
}