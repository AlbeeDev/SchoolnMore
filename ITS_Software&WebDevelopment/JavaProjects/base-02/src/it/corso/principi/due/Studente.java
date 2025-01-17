package it.corso.principi.due;

import it.corso.principi.uno.Persona;

public class Studente extends Persona {

    private double mediaVoti;

    public Studente(String nome, String cognome, int eta, double mediaVoti) {
        super(nome, cognome, eta);
        this.mediaVoti = mediaVoti;
    }

    public double getMediaVoti() {
        return mediaVoti;
    }

    public void setMediaVoti(double mediaVoti) {
        this.mediaVoti = mediaVoti;
    }

    @Override
    public void function() {
        System.out.println(getNome() + " studia");
    }
}
