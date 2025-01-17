package albano.alex;

public class Furgone extends Veicolo{
    double portata;
    double lunghezza;
    double larghezza;
    double altezza;

    public Furgone(String marca, String modello, String numeroTarga, double tarifaGiornaliera, double portata, double lunghezza, double larghezza, double altezza) {
        super(marca, modello, numeroTarga, tarifaGiornaliera);
        this.portata = portata;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public double getPortata() {
        return portata;
    }

    public void setPortata(double portata) {
        this.portata = portata;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return super.toString() + " di tipo Furgone{" +
                "portata=" + portata +
                ", lunghezza=" + lunghezza +
                ", larghezza=" + larghezza +
                ", altezza=" + altezza +
                '}';
    }
}
