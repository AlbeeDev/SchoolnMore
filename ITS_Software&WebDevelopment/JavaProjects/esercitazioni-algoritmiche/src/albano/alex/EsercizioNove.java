package albano.alex;

import javax.swing.*;

public class EsercizioNove {
    public static void main(String[] args) {
        String player1= JOptionPane.showInputDialog("Inserisci il player 1");
        String player2= JOptionPane.showInputDialog("Inserisci il player 2");

        String sceltap1 = JOptionPane.showInputDialog(player1 +" inserisci una scelta (S,C,F)");
        String sceltap2 = JOptionPane.showInputDialog(player2 +" inserisci una scelta (S,C,F)");

        if (sceltap1.equals(sceltap2)){
            JOptionPane.showMessageDialog(null,"Pareggio");
        } else if(sceltap1.equals("sasso") && sceltap2.equals("carta")){
            JOptionPane.showMessageDialog(null,"vittoria player2");
        } else if (sceltap2.equals("sasso") && sceltap1.equals("carta")) {
            JOptionPane.showMessageDialog(null,"vittoria player1");
        } else if (sceltap1.equals("sasso") && sceltap2.equals("forbici")) {
            JOptionPane.showMessageDialog(null, "Vittoria player1");
        } else if (sceltap2.equals("sasso") && sceltap1.equals("forbici")) {
            JOptionPane.showMessageDialog(null, "Vittoria player2");
        } else if (sceltap1.equals("carta") && sceltap2.equals("forbici")) {
            JOptionPane.showMessageDialog(null, "Vittoria player2");
        } else if (sceltap2.equals("carta") && sceltap1.equals("forbici")) {
            JOptionPane.showMessageDialog(null, "Vittoria player1");
        }



    }

}
