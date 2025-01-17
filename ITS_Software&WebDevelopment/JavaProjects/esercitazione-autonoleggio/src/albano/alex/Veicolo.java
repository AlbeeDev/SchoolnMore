package albano.alex;

public class Veicolo {
    String marca;
    String modello;
    String numeroTarga;
    double tarifaGiornaliera;

    public Veicolo(String marca, String modello, String numeroTarga, double tarifaGiornaliera) {
        this.marca = marca;
        this.modello = modello;
        this.numeroTarga = numeroTarga;
        this.tarifaGiornaliera = tarifaGiornaliera;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getNumeroTarga() {
        return numeroTarga;
    }

    public void setNumeroTarga(String numeroTarga) {
        this.numeroTarga = numeroTarga;
    }

    public double getTarifaGiornaliera() {
        return tarifaGiornaliera;
    }

    public void setTarifaGiornaliera(double tarifaGiornaliera) {
        this.tarifaGiornaliera = tarifaGiornaliera;
    }

    @Override
    public String toString() {
        return "\n- Veicolo{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", numeroTarga='" + numeroTarga + '\'' +
                ", tarifaGiornaliera=" + tarifaGiornaliera +
                '}';
    }
}
