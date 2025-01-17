package it.corso.multithread;

import java.util.Scanner;

public class Utilizzo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("informazioni raccolte... digita i per inviarle");
        if(sc.next().equalsIgnoreCase("i")){
//            StringBuilder sb = new StringBuilder();
//            long start = System.currentTimeMillis();
//            for (int i = 0; i < 400000000; i++) {
//                sb.append('a');
//            }
//            long end = System.currentTimeMillis();
//            System.out.println("invio completato " + (end - start)+"ms");
            invio.start();
        }
        System.out.println("procedi con la prossima operazione");
        sc.close();
    }

    static Thread invio = new Thread(new Runnable() {
        public void run() {
            StringBuilder sb = new StringBuilder();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 400000000; i++) {
                sb.append('a');
            }
            long end = System.currentTimeMillis();
            System.out.println("invio completato " + (end - start)+"ms");
        }
    });
}
