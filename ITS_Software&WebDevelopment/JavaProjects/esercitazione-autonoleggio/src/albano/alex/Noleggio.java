package albano.alex;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Noleggio {
    LocalDate dataInizio;
    LocalDate dataFine;
    Veicolo veicolo;
    Cliente cliente;
    double importoTotale;

    public Noleggio(LocalDate dataInizio, LocalDate dataFine, Veicolo veicolo, Cliente cliente) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.veicolo = veicolo;
        this.cliente = cliente;
        this.importoTotale = veicolo.getTarifaGiornaliera() * ChronoUnit.DAYS.between(this.dataInizio, this.dataFine);
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    public void setVeicolo(Veicolo veicolo) {
        this.veicolo = veicolo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getImportoTotale() {
        return importoTotale;
    }

    public void setImportoTotale(double importoTotale) {
        this.importoTotale = importoTotale;
    }

    @Override
    public String toString() {
        return "\n-- Noleggio{" +
                "dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", veicolo=" + veicolo +
                ", cliente=" + cliente +
                ", importoTotale=" + importoTotale +
                '}';
    }
}
