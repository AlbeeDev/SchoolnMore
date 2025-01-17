package it.corso.array;

import java.util.Arrays;

public class Vettore {
    public static void main(String[] args) {

        int[] array1;
        array1 = new int[10];
        array1[0] = 10;
        array1[1] = 5;
        array1[2] = 6;
        int[] array2 = {40,20};

        System.out.println(array1[1]);
        System.out.println(Arrays.toString(array1));
        System.out.println(array1.length);

        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
    }
}
