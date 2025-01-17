package it.corso.composizione;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prenotazione {
	
	// attributi di istanza
	private LocalDate dataArrivo;
	private LocalDate dataPartenza;
	private String importoTotale;
	private Cliente cliente;
	private Camera camera;
	
	// costruttore completo
	public Prenotazione(LocalDate dataArrivo, LocalDate dataPartenza, 
			Cliente cliente, Camera camera) {
		this.dataArrivo = dataArrivo;
		this.dataPartenza = dataPartenza;
		this.cliente = cliente;
		this.camera = camera;
		this.importoTotale = calcoloImporto();
	}
	
	// metodo per il calcolo dell'importo totale
	private String calcoloImporto() {
		double totale = camera.getTariffaNotte() * 
				(ChronoUnit.DAYS.between(dataArrivo, dataPartenza) + 1);
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
		return decimalFormat.format(totale);
	}
	
	// getter e setter
	public LocalDate getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(LocalDate dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public LocalDate getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(LocalDate dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public String getImportoTotale() {
		return importoTotale;
	}
	public void setImportoTotale(String importoTotale) {
		this.importoTotale = importoTotale;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public String toString() {
		return "Prenotazione [dataArrivo=" + dataArrivo + ", dataPartenza=" + dataPartenza + 
				", importoTotale=" + importoTotale + ", cliente=" + cliente + ", camera=" + camera + "]";
	}
}