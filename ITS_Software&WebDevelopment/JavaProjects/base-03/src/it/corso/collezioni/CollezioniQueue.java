package it.corso.collezioni;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollezioniQueue {
    public static void main(String[] args) {
        Queue<String> messaggi = new LinkedList<>();
        messaggi.add("ciao");
        messaggi.add("come stai");
        messaggi.offer("bene");
        messaggi.add("ciao mondo");

        System.out.println(messaggi.peek());
        System.out.println(messaggi.poll());
        System.out.println(messaggi);
        System.out.println(messaggi.remove());
        System.out.println(messaggi);

    }
}
