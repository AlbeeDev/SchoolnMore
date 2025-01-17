package albano.alex;

import java.util.Scanner;

public class EsercizioTre {
    public static void main(String[] args) {

        System.out.println("inserisci il tuo nome di battesimo");
        Scanner sc = new Scanner(System.in);

        String nome = sc.nextLine();
        char[] charnome = nome.toCharArray();

        for(int i=charnome.length-1; i>=0; i--) {
            System.out.print(charnome[i]);
        }
    }
}
