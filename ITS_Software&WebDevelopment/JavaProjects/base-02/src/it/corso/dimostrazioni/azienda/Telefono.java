package it.corso.dimostrazioni.azienda;

public abstract class Telefono implements Utility{

    private int durataBatteria;

    public Telefono(int durataBatteria) {
        this.durataBatteria = durataBatteria;
    }

    public int getDurataBatteria() {
        return durataBatteria;
    }

    public void setDurataBatteria(int durataBatteria) {
        this.durataBatteria = durataBatteria;
    }

    public void invioChiamata(String numero){
        System.out.println("chiamo il numero " + numero);
    }

    public abstract void connessione();
}
