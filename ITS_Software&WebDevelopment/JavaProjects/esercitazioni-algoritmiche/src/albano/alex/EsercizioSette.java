package albano.alex;

import javax.swing.*;

public class EsercizioSette {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Inserisci un numero"));

        if(num1<=1){
            JOptionPane.showMessageDialog(null, "numero invalido");
        } else {
            String message = "numero primo";
            for (int i = 2; i < num1; i++) {
                if (num1 % i == 0) {
                    message = "numero non primo";
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, message);
        }
    }
}
