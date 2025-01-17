package it.corso.principi.uno;

public class Persona {

    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void camminare(){
        System.out.println(nome + " cammina");
    }

    protected void mangiare(){
        System.out.println(nome + " mangia");
    }
    void parlare(){
        System.out.println(nome + " parla");
    }

    public void function(){
        System.out.println(nome + " fa qualcosa");
    }
}
