package it.corso.composizione;

public class Camera {
	
	// attributi di istanza
	private int numero;
	private double tariffaNotte;
	
	// costruttore completo
	public Camera(int numero, double tariffaNotte) {
		this.numero = numero;
		this.tariffaNotte = tariffaNotte;
	}

	// getter e setter
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getTariffaNotte() {
		return tariffaNotte;
	}
	public void setTariffaNotte(double tariffaNotte) {
		this.tariffaNotte = tariffaNotte;
	}

	// rappresentazione testuale
	@Override
	public String toString() {
		return "Camera [numero=" + numero + ", tariffaNotte=" + tariffaNotte + "]";
	}
}