package it.corso.modellazione;

import java.util.Arrays;

public class TestSmartphone {
    public static void main(String[] args) {
        Smartphone sm1 = new Smartphone(300.15,"LG","c-220",6.55);
        Smartphone sm2 = new Smartphone("Samsung","j50",5.57);
        Smartphone sm3 = new Smartphone();

        sm1.setDimDisplay(6.57);
        sm2.setPrezzo(500.56);


        sm1.invioChiamate("7923327487");

        Smartphone.setCatalogo(0, sm1);
        Smartphone.setCatalogo(1, sm2);
        Smartphone.setCatalogo(2, sm3);
        System.out.println(Arrays.toString(Smartphone.getCatalogo()));

        Smartphone.cambiaTema("dark");

        System.out.println(sm1);
        System.out.println(sm2);
        System.out.println(sm3);

    }
}
