package it.corso.dimostrazioni.multithread;

import java.time.LocalTime;

public class Negozio {
    private boolean occupato;

    public synchronized void ingresso(){
        while (occupato){
            try {
                wait();
            }catch (Exception ignored){}
        }
        occupato = true;
        Cliente cliente = (Cliente) Thread.currentThread();
        System.out.println(LocalTime.now()+" entra nel negozio "+cliente.getNome());
    }

    public synchronized void uscita(){
        occupato = false;
        Cliente cliente = (Cliente) Thread.currentThread();
        System.out.println(LocalTime.now()+" esce nel negozio "+cliente.getNome());
        notifyAll();
    }
}
