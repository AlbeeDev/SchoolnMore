import java.util.Random;

class MioBuffer{
    private int data[]; 
    private int elementi;
    private boolean consumato = true;  

    public MioBuffer(int elementi){
        this.elementi=elementi;
        data = new int[elementi];
    }

    public synchronized void riempi (int i, int value) throws InterruptedException {
        while (!consumato){
            wait();
        }
        
        data[i] = value;
        consumato = false;

        System.out.println(Thread.currentThread().getName() + " ha scritto in " + i + " il valore: " + data[i]);

         notifyAll();
    }
    public synchronized int svuota (int i) throws InterruptedException{
        while (consumato){
            wait();
        }

        consumato = true;
        System.out.println(Thread.currentThread().getName() + " ha letto in " + i + " il valore: " + data[i]);

        notifyAll();
        return data[i];
    }

    public int getElementi(){ 
        return elementi; 
    }
}

class Producer extends Thread{
    private MioBuffer b;

    public Producer(MioBuffer b) { 
        this.b = b; 
    }

    public void run() {
        for (int i = 0; i < b.getElementi(); i++){
            try{
                Thread.sleep(new Random().nextInt(2000)+100);
                b.riempi(i,new Random().nextInt(100));
            }
            catch (InterruptedException ex) {}
        }
    }
}

class Consumer extends Thread{
    private MioBuffer b;

    public Consumer(MioBuffer b) { 
        this.b = b; 
    }

    public void run(){
        for (int i = 0; i < b.getElementi(); i++){
            try {
                Thread.sleep(new Random().nextInt(2000)+100);
                b.svuota(i);
            }
            catch (InterruptedException ex) {}
        }
    }
}

public class MonitorProdCons {
    public static void main(String args[]){
    
        MioBuffer b = new MioBuffer(10); 
        Thread prod = new Producer(b); 
        Thread cons = new Consumer(b);

        prod.start();
        cons.start();
    }
}