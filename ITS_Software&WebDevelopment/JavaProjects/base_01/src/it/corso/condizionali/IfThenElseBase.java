package it.corso.condizionali;

import javax.swing.*;

public class IfThenElseBase {
    public static void main(String[] args) {
        String genere = JOptionPane.showInputDialog("Inserisci il tuo genere").toLowerCase();

        if(genere.equals("m")){
            JOptionPane.showMessageDialog(null,"benvenuto");
        }
        else if(genere.equals("f")){
            JOptionPane.showMessageDialog(null,"benvenuta");
        }
        else if(genere.isEmpty()){
            JOptionPane.showMessageDialog(null," non hai digitato nulla");
        }
        else {
            JOptionPane.showMessageDialog(null,"/");
        }
    }
}
