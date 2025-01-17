package it.corso.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome;
        String cognome;
        int eta = -1;

        System.out.println("Digita nome: ");
        nome = scanner.nextLine();
        System.out.println("Digita cognome: ");
        cognome = scanner.nextLine();

        System.out.println("Digita eta valida: ");
        eta = scanner.nextInt();


        scanner.close();

        System.out.println(nome + " " + cognome + " " + eta);
    }
}
