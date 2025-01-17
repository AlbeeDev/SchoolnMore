package it.corso.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("inserisci nome: ");
        String nome = br.readLine();
        System.out.println("inserisci cognome: ");
        String cognome = br.readLine();

        br.close();

        System.out.format("ti chiami %s %s",nome,cognome);

        System.out.println("nome: " + nome + " cognome: " + cognome);


    }
}
