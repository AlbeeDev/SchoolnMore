package it.corso.datatype;

public class Strighe {
    public static void main(String[] args) {

        String stringa1 = "ciao";
        String stringa2 = new String("ciao");

        System.out.println(stringa1 == stringa2);
        System.out.println(stringa1.equals(stringa2));

        System.out.println(stringa1.length());
        System.out.println(stringa2.charAt(stringa2.length()-1));
        System.out.println(stringa1.substring(1,3));
        System.out.println(stringa1.replace("o","*"));

        StringBuilder sb = new StringBuilder("Ciao Mondo");
        sb.reverse();
        System.out.println(sb);
    }
}
