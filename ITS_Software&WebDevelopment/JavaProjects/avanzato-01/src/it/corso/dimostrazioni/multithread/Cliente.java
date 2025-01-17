package it.corso.dimostrazioni.multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cliente extends Thread {
    private String nome;
    private Negozio negozio;
    private static List<Cliente> attesa = new ArrayList<Cliente>();

    public Cliente(String nome, Negozio negozio) {
        this.nome = nome;
        this.negozio = negozio;
    }

    public String getNome() {
        return nome;
    }

    public static List<Cliente> getAttesa() {
        return attesa;
    }

    @Override
    public String toString() {
        return "Cliente" + nome;
    }

    @Override
    public void run() {
        int permanenza = new Random().nextInt(1,11);
        negozio.ingresso();
        Cliente.attesa.remove(this);
        if(Cliente.attesa.size() > 0){
            System.out.println(Arrays.toString(Cliente.attesa.toArray()));
        } else {
            System.out.println("nessuno in attesa");
        }
        try {
            Thread.sleep(permanenza* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        negozio.uscita();
    }
}
