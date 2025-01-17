package it.corso.operatori;

public class OperatoriAritmetici {
    public static void main(String[] args) {
        int int1 = 10;
        int int2 = 10;
        String string1 = "ciao";
        System.out.println(int1 + int2);
        System.out.println(string1+int1+int2);
        System.out.println(string1+(int1+int2));

        double double1 = 5.0;
        int int3 = 2;
        System.out.println(double1/int3);

        System.out.println(double1 % int3);

        byte b = 10;
        int num = b;
        short numsho = (short) num;
    }
}
