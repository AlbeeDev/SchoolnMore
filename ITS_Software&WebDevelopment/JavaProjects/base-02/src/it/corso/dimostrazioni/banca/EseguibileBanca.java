package it.corso.dimostrazioni.banca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EseguibileBanca {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("benvenuto in banca. \n Apri conto con - n");

        if(br.readLine().equalsIgnoreCase("n")) {
            System.out.println("inserisci nome e cognome");

            ContoCorrente conto = new ContoCorrente(br.readLine());
            System.out.println("Complimenti "+ conto);

            System.out.println("digita O per operazione / altro per uscire");

            if(br.readLine().equalsIgnoreCase("o")){
                System.out.println("digita importo (0 per terminare)");
                String importo;
                while (!(importo = br.readLine()).equals("0")){
                    if(ContoCorrente.validaImporto(importo)) {
                        conto.setSaldo(importo);
                        System.out.println("operazione riuscita. saldo attuale: "+conto.getSaldo()+" Euro");
                    } else {
                        System.out.println("importo invalido");
                    }
                }
                System.out.println("arrivederci "+ conto.getIntestatario());
            }else {
                System.out.println("arrivederci "+ conto.getIntestatario());
            }

        } else {
            System.out.println("arrivederci");
        }

    }
}
