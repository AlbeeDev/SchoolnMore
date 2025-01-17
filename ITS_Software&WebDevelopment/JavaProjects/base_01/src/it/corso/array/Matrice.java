package it.corso.array;

import java.util.Arrays;

public class Matrice {

    public static void main(String[] args) {
        String[][] matrice = new String[2][2];
        matrice[0][0] = "Ciao";
        matrice[1][1] = "Mondo";


        System.out.println(Arrays.toString(matrice[0]));
        System.out.println(Arrays.toString(matrice[1]));

        int[][] matrice2 = {
                            {1,2},
                            {3,4}
                            };

        System.out.println(matrice2.length);

        System.out.println(Arrays.deepToString(matrice));



    }
}
