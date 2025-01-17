package it.corso.multithread;

public class Introduzione {
    public static void main(String[] args) {
        System.out.println("sono thread " + Thread.currentThread().getName() + " -> inizio programma");
        Thread laura = new Thread(new Multiplo("laura"));
        laura.start();
        Gianni gianni = new Gianni();
        gianni.start();
        mario.start();
        Thread luigi = new Thread(new Multiplo("luigi"));
        luigi.start();

        try {
            mario.join();
            gianni.join();
            laura.join();
            luigi.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("sono thread " + Thread.currentThread().getName() + " -> fine programma");
    }

    static Thread mario = new Thread(new Runnable() {
        String nome = "Mario";
        @Override
        public void run() {
            System.out.println("salve, sono thread " + Thread.currentThread().getName());
        }
    });
}

class Gianni extends Thread {

    private String nome = "Gianni";

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("sono thread " + nome + " -> " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Multiplo implements Runnable {
    private String nome;

    public Multiplo(String nome) {
        this.nome = nome;
    }



    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("sono thread " + nome + " -> " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
