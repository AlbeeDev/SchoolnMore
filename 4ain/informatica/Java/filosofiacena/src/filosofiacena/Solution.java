package filosofiacena;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {
    private static final int N_FILOSOFI = 5;
    private static final Lock[] bacchette = new Lock[N_FILOSOFI];

    public static void main(String[] args) {
        for (int i = 0; i < N_FILOSOFI; i++) {
            bacchette[i] = new ReentrantLock();
        }

        Filosofo[] filosofi = new Filosofo[N_FILOSOFI];
        for (int i = 0; i < N_FILOSOFI; i++) {
            filosofi[i] = new Filosofo(i);
        }

        for (int i = 0; i < N_FILOSOFI; i++) {
            filosofi[i].start();
        }
    }

    private static class Filosofo extends Thread {
        private final int id;
        private final Lock bacchettaSx;
        private final Lock bacchettaDx;

        public Filosofo(int id) {
            this.id = id;
            this.bacchettaSx = bacchette[id];
            this.bacchettaDx = bacchette[(id + 1) % N_FILOSOFI];
        }

        private void pensa() throws InterruptedException {
            System.out.println("Filosofo " + id + " pensa");
            Thread.sleep((long) (Math.random() * 1000));
        }

        private void mangia() throws InterruptedException {
            bacchettaDx.lock();
            try {
                System.out.println("Filosofo " + (id+1) + " prende la bacchetta " + ((id + 1) % N_FILOSOFI +1));
                bacchettaSx.lock();
                try {
                    System.out.println("Filosofo " + (id+1) + " prende la bacchetta " + (id+1));
                    System.out.println("Filosofo " + (id+1) + " mangia");
                    Thread.sleep((long) (Math.random() * 1000));
                } finally {
                    bacchettaSx.unlock();
                    System.out.println("Filosofo " + (id+1) + " lascia la bacchetta " + (id+1));
                }
            } finally {
                bacchettaDx.unlock();
                System.out.println("Filosofo " + (id+1) + " lascia la bacchetta " + ((id + 1) % N_FILOSOFI +1)); 
            } 
        }

        @Override
        public void run() {
            while (true) {
                try {
                    pensa();
                    mangia();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}