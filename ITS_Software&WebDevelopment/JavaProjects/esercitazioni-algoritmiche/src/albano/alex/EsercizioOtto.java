package albano.alex;

import javax.swing.*;
import java.util.Random;

public class EsercizioOtto {
    public static void main(String[] args) {
        final int CASUALE = new Random().nextInt(10);
        int tentativi = 1;
        int num1;

        while ((num1 = Integer.parseInt(JOptionPane.showInputDialog("inserisci un numero tra 1 e 10"))) != CASUALE){
            tentativi++;
        }

        JOptionPane.showMessageDialog(null,"Congratulazioni ha fatto solo "+ tentativi+" tentativi");


    }
}
