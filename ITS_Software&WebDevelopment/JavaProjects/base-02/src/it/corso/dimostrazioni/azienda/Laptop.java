package it.corso.dimostrazioni.azienda;

public class Laptop extends Computer{

    private boolean touchscreen;

    public Laptop(String os, boolean touchscreen) {
        super(os);
        this.touchscreen = touchscreen;
    }

    @Override
    public void timeout() {
        System.out.println("Chiudi lo schermo");
    }

    public boolean isTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        this.touchscreen = touchscreen;
    }

    @Override
    public void init() {
        System.out.println("accendi il pc se carico e avvia configurazione");
    }
}
