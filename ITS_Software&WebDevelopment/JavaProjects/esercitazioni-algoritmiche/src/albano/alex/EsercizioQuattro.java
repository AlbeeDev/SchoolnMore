package albano.alex;

import javax.swing.*;

public class EsercizioQuattro {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Inserisci numero 1"));
        int num2;
        while((num2 = Integer.parseInt(JOptionPane.showInputDialog("Inserisci numero 2"))) <= num1){
            JOptionPane.showMessageDialog(null, "numero 2 minore o uguale di numero 1. riprova");
        }
        while(num1 <= num2){
            if(num1%2==0){
                System.out.println(num1);
            }
            num1++;
        }


    }
}
