package it.corso.principi.due;

import it.corso.principi.uno.Persona;

public class Lavoratore extends Persona {

    private double reddito;

    public Lavoratore(String nome, String cognome, int eta, double reddito) {
        super(nome, cognome, eta);
        this.reddito = reddito;
    }

    public double getReddito() {
        return reddito;
    }

    public void setReddito(double reddito) {
        this.reddito = reddito;
    }

    @Override
    public void function() {
        System.out.println(getNome() + " lavora");
    }
}
