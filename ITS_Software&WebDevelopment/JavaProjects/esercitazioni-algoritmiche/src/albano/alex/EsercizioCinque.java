package albano.alex;

import java.util.Random;

public class EsercizioCinque {
    public static void main(String[] args) {
        int[][] matrice = new int[2][3];

        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[0].length; j++){
                matrice[i][j] = new Random().nextInt(50,101);
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
