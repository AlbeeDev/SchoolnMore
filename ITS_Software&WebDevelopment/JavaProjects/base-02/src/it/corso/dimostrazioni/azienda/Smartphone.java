package it.corso.dimostrazioni.azienda;

public class Smartphone extends Telefono{

    private String tipoSim;

    public Smartphone(int durataBatteria, String tipoSim) {
        super(durataBatteria);
        this.tipoSim = tipoSim;
    }

    public String getTipoSim() {
        return tipoSim;
    }

    public void setTipoSim(String tipoSim) {
        this.tipoSim = tipoSim;
    }

    @Override
    public void connessione() {
        System.out.println("inserisci sim e configura");
    }

    @Override
    public void init() {
        System.out.println("inserisci sim e imposta account");
    }
}
