package it.corso.dimostrazioni.azienda;

public interface Utility{

    String Marca = "azienda SpA";

    void init();

    default void ricaricaBatteria() {
        System.out.println("collega alla presa di corrente");
    }
}
