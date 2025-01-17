package it.corso.controller;

import it.corso.model.Fattura;
import it.corso.repository.FatturaRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class FatturaController {

    private static FatturaRepository fr = new FatturaRepository();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("premi i per inserire fattura / v per visualizzarle / altro per uscire");

        String operation = sc.next();

        if(operation.equalsIgnoreCase("i")){
            Fattura f = new Fattura();

            boolean validData = false;
            while (!validData) {
                System.out.println("Inserisci data di emissione (Formato yyyy-MM-dd):");
                String dataString = sc.next();
                try {
                    //f.setDataEmissione(Date.valueOf(dataString));
                    f.setDataEmissione(LocalDate.parse(dataString));
                    validData = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Formato data non valido. Riprova.");
                }
            }

            boolean validImponibile = false;
            while (!validImponibile) {
                System.out.println("Inserisci imponibile:");
                String imponibileString = sc.next();
                try {
                    f.setImponibile(Double.parseDouble(imponibileString));
                    if (f.getImponibile() < 0) {
                        System.out.println("L'imponibile deve essere un numero positivo. Riprova.");
                    } else {
                        validImponibile = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Imponibile non valido. Devi inserire un numero. Riprova.");
                }
            }

            boolean validNomeCognome = false;
            while (!validNomeCognome) {
                System.out.println("Inserisci nome e cognome:");
                sc.nextLine();
                f.setNomeCognome(sc.nextLine().trim());
                if (!f.getNomeCognome().isEmpty()) {
                    validNomeCognome = true;
                } else {
                    System.out.println("Nome e cognome non possono essere vuoti. Riprova.");
                }
            }

            fr.creaFattura(f);

        } else if(operation.equalsIgnoreCase("v")){
            for(Fattura f:fr.elencoFatture()){
                System.out.println(f.getDataEmissione());
                System.out.println(f);
            }
        }
    }
}
