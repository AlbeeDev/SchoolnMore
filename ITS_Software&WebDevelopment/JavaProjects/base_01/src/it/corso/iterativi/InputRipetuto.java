package it.corso.iterativi;

import java.util.Scanner;

public class InputRipetuto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("inserisci un numero: ");
        int sum = 0;
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if(num==0){
                System.out.println(sum);
                break;
            }
            else {
                sum += num;
            }

        }
        sc.close();
    }
}
