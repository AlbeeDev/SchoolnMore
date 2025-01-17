package it.corso.model;

import java.time.LocalDate;

public class Fattura {
    private int numero;
    private LocalDate dataEmissione;
    private double imponibile;
    private String nomeCognome;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public double getImponibile() {
        return imponibile;
    }

    public void setImponibile(double imponibile) {
        this.imponibile = imponibile;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    @Override
    public String toString() {
        return "Fattura{" +
                "numero=" + numero +
                ", data di emissione=" + dataEmissione +
                ", imponibile=" + imponibile +
                ", totale da pagare='" + imponibile * 1.22 + '\'' +
                ", nomeCognome='" + nomeCognome + '\'' +
                '}';
    }
}
