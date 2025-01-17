package it.corso.modellazione;

public class Smartphone {

    double prezzo;
    String marca;
    String modello;
    double dimDisplay;

    static Smartphone[] catalogo;

    static {
        catalogo = new Smartphone[3];
    }

    public Smartphone(double prezzo, String marca, String modello, double dimDisplay) {
        this.prezzo = prezzo;
        this.marca = marca;
        this.modello = modello;
        this.dimDisplay = dimDisplay;
    }

    public Smartphone(String marca, String modello, double dimDisplay) {
        this.marca = marca;
        this.modello = modello;
        this.dimDisplay = dimDisplay;
    }

    public Smartphone(){}

    public void invioChiamate(String numero){
        System.out.println("invio chiamata a: " + numero);
    }

    public void invioMessaggio(String numero){
        System.out.println("invio messaggio a: " + numero);
    }

    public static void cambiaTema(String tema){
        for(Smartphone sm : catalogo){
            System.out.println("modifica tema a: " + sm.modello+ "in "+ tema);
        }
    }

    public static Smartphone[] getCatalogo() {
        return catalogo;
    }

    public static void setCatalogo(int index, Smartphone sm) {
        catalogo[index] = sm;
    }

    public double getDimDisplay() {
        return dimDisplay;
    }

    public void setDimDisplay(double dimDisplay) {
        this.dimDisplay = dimDisplay;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String stampaSmartphone(){
        return marca + " " + modello + " " + dimDisplay + " " + prezzo;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "prezzo=" + prezzo +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", dimDisplay=" + dimDisplay +
                '}';
    }
}
