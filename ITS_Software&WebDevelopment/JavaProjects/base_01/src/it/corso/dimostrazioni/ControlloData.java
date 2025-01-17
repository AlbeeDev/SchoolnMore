package it.corso.dimostrazioni;

import java.util.Scanner;

public class ControlloData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("inserisci una data valida (dd-mm-yy):");

        String data = sc.nextLine();

        String[] dataarray = data.split("-");

        if(Integer.parseInt(dataarray[0])<=0 && Integer.parseInt(dataarray[0])>30){
            System.out.println("errore giorno");
        }

        if(Integer.parseInt(dataarray[1])<=0 && Integer.parseInt(dataarray[1])>12){
            System.out.println("errore mese");
        }
    }
}
