package centrostampa;

import java.util.*;
class Monitor {
    private static final int NUM_PRN = 5;
    private final int[] occupato = new int[NUM_PRN];
    private final boolean[] aColori = new boolean[NUM_PRN]; // 0-->B/N, 1-->COLORI
    private int ncolori, nbianconero;

    public Monitor() {
        Random random = new Random();
        for(int j=0; j<NUM_PRN; j++) {
            occupato[j] = -1; //libero
            aColori[j] = random.nextBoolean(); // B/N
            ncolori += aColori[j] ? 1 : 0;
            nbianconero += aColori[j] ? 0 : 1;
        }
    }

    private int getIdoneaLibera(Documento doc) {
        for(int j=0; j<NUM_PRN; ++j) {
            // la stampante è libera && la stampante è a colori || il documento non è a colori
            if(occupato[j]==-1 && (aColori[j] || !doc.colorato)) {
                return j;
            }
        }
        return -1;
    }

    public synchronized void entra(Documento doc) {
        int j;
        while((j = getIdoneaLibera(doc))<0) {
            System.out.println("\tdocumento "+doc.id+", colorato "+doc.colorato+" accodato");
            try { wait(); } catch (InterruptedException ex) { ex.printStackTrace(); }
        }

        //prende posto
        occupato[j] = doc.id;
        if(aColori[j])
            ncolori--;
        else
            nbianconero--;
        System.out.println("Documento "+doc.id+" in stampa, stampante "+j+", colorato "+doc.colorato);
        System.out.println("ncolori: "+ncolori+", nbianconero: "+nbianconero);
    }

    public synchronized void esce(Documento doc){
        for (int j=0; j<NUM_PRN; ++j) {
            if(occupato[j] == doc.id) {
                //lo libera
                occupato[j] = -1;
                if(aColori[j])
                    ncolori++;
                else
                    nbianconero++;
//				System.out.println("ncolori: "+ncolori+", nbianconero: "+nbianconero);
            }
        }
        notify();
    }
}

class Documento extends Thread {
    final int id;
    final boolean colorato;
    final int n_pagine;
    private final Monitor monitor;

    public Documento(int id, boolean colorato, int n_pagine, Monitor monitor) {
        this.id = id;
        this.colorato = colorato;
        this.n_pagine = n_pagine;
        this.monitor = monitor;
    }
    private void delay(int n_pagine) {
        try { Thread.sleep(10*n_pagine); } catch (InterruptedException ex) { ex.printStackTrace(); }
    }
    @Override
    public void run() {
        monitor.entra(this);
        delay(n_pagine); //stampa le pagine
        monitor.esce(this);
        System.out.println("documento "+id+" stampato");
    }
}

public class CentroStampa {
    private static final int N_DOC = 60;
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        Thread[] documenti = new Thread[N_DOC];
        Random random = new Random();
        for (int i = 0; i < N_DOC; i++) {
            // id, colorato, n_pagine
            documenti[i] = new Documento(i, random.nextBoolean(), random.nextInt(1, 51), monitor);
        }

        for(Thread documento : documenti) {
            documento.start();
        }

        int contaPagine = 0;
        int contaDoc = 0;
        for(Thread documento : documenti) {
            documento.join();
            Documento doc = (Documento)documento;
            System.out.println("\t\tRICEVUTA documento "+doc.id+", pagine: "+doc.n_pagine);
            contaPagine += doc.n_pagine;
            contaDoc += 1;
            System.out.println("main ha stampato "+contaDoc+" documenti");
        }
        System.out.println("main ha stampato "+contaPagine+" pagine");
    }
}