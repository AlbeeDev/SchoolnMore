package albano.alex;

public class Autovettura extends  Veicolo{
    int numeroPorte;
    int numeroPosti;

    public Autovettura(String marca, String modello, String numeroTarga, double tarifaGiornaliera, int numeroPorte, int numeroPosti) {
        super(marca, modello, numeroTarga, tarifaGiornaliera);
        this.numeroPorte = numeroPorte;
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    @Override
    public String toString() {
        return super.toString() + " di tipo Autovettura{" +
                "numeroPorte=" + numeroPorte +
                ", numeroPosti=" + numeroPosti +
                '}';
    }
}
