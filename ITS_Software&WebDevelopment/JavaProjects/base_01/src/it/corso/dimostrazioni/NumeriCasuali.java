package it.corso.dimostrazioni;

import java.util.Arrays;
import java.util.Random;

public class NumeriCasuali {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int count = 0;
        /*
        for(int i = 0; i < array1.length; i++){
            array1[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(array1));
        */
        while (count < array1.length){
            boolean duplicato = false;
            int casuale = new Random().nextInt(11);
            for (int i = 0; i < array1.length; i++){
                if (casuale == array1[i]){
                    duplicato = true;
                }
            }
            if (!duplicato){
                array1[count] = casuale;
                count++;
            }
        }
        System.out.println(Arrays.toString(array1));
    }

}
