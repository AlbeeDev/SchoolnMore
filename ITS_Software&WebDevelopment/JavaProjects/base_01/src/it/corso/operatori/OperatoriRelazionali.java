package it.corso.operatori;

public class OperatoriRelazionali {
    public static void main(String[] args) {
        int int1 = 10;
        int int2 = 20;

        System.out.println(int1 == int2);

        String str1 = "abc";
        String str2 = "def";

        System.out.println(str1.concat(str2));
        str1 = str1.concat(str2);
        System.out.println(str1);

        System.out.println(int1++ + " " + ++int2);
    }
}
