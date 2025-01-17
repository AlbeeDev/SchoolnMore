package it.corso.metodi;

public class Metodi {

    public static void main(String[] args) {
        stampaSaluto();
        System.out.println(tornaSaluto());
        salutami("mario");
        System.out.println(getCharacterCount(new String[]{"mario","luigi"}));
    }

    public static void stampaSaluto(){
        System.out.println("Ciao Mondo");
    }

    public static String tornaSaluto(){
        return "ciao";
    }

    public static void salutami(String nome){
        System.out.println("ciao "+nome);
    }

    public static String concatena(String str1, String str2){
        return str1.concat(str2);
    }

    public static int getCharacterCount(String[] strs){
        int charcount = 0;
        for (int i = 0; i < strs.length; i++) {
            charcount += strs[i].length();
        }
        return charcount;
    }

    public static int[] getCharLength(String... strs){
        int[] length = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            length[i] = strs[i].length();
        }
        return length;
    }
}
