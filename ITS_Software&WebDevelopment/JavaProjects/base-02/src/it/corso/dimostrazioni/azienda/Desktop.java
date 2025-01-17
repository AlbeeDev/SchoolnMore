package it.corso.dimostrazioni.azienda;

public class Desktop extends Computer{

    private boolean includedMonitor;

    public Desktop(String os, boolean includedMonitor) {
        super(os);
        this.includedMonitor = includedMonitor;
    }

    @Override
    public void timeout() {
        System.out.println("scegli sleep dal start");
    }

    public boolean isIncludedMonitor() {
        return includedMonitor;
    }

    public void setIncludedMonitor(boolean includedMonitor) {
        this.includedMonitor = includedMonitor;
    }

    @Override
    public void init() {
        System.out.println("collega alla presa di corrente e avvia configurazione");
    }
}
