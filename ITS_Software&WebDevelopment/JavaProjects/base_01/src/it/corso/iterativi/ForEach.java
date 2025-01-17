package it.corso.iterativi;

public class ForEach {
    public static void main(String[] args) {
        int[] array1 = {10,25,12,32,11,9,20,55};

        for(int num : array1) {
            System.out.println(num);
        }

        for(int num : array1) {
            if(num%2==0) {
                System.out.println(num);
            }
        }



    }
}
