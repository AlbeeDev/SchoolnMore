package it.corso.dimostrazioni.azienda;

public class TestAzienda {
    public static void main(String[] args) {
        Desktop d = new Desktop("win11",true);
        Laptop l = new Laptop("win10",false);
        Smartphone s = new Smartphone(10,"sim1");
        Cordless c = new Cordless(5,7);

        d.init();
        d.installSoftware("chrome");
        d.timeout();
        d.ricaricaBatteria();

        c.init();
        c.invioChiamata("45363425232");
        c.connessione();
        c.ricaricaBatteria();

        Utility[] catalogo = {d,l,s,c};

        for (Utility u : catalogo) {
            u.init();
        }

    }
}
