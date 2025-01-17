package it.corso.dimostrazioni.azienda;

public abstract class Computer implements Utility{

    private String os;

    public Computer(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void installSoftware(String swName) {
        System.out.println("Installing "+ swName);

    }

    public abstract void timeout();

}
