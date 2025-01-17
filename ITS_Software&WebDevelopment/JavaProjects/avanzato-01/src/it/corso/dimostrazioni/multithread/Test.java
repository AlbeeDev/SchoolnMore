package it.corso.dimostrazioni.multithread;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomiclienti = {"mario","gianni","luca","laura","luigi"};
        Negozio negozio = new Negozio();
        for (String nome : nomiclienti) {
            Cliente.getAttesa().add(new Cliente(nome, negozio));
        }
        System.out.println("lista attesa : "+Cliente.getAttesa());

        if(sc.next().equals("a")){
            System.out.println("apertura negozio");
            for(Cliente cliente : Cliente.getAttesa()){
                cliente.start();
            }
        }


    }
}
