package it.corso.dimostrazioni.azienda;

public class Cordless extends Telefono{

    private int raggioAzione;

    public Cordless(int durataBatteria, int raggioAzione) {
        super(durataBatteria);
        this.raggioAzione = raggioAzione;
    }

    public int getRaggioAzione() {
        return raggioAzione;
    }

    public void setRaggioAzione(int raggioAzione) {
        this.raggioAzione = raggioAzione;
    }

    @Override
    public void connessione() {
        System.out.println("collega il cavo alla presa telefonica");
    }

    @Override
    public void init() {
        System.out.println("collega alla presa telefonica e telefona");
    }
}
