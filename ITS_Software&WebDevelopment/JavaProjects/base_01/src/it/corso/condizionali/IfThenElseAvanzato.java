package it.corso.condizionali;

import javax.swing.*;

public class IfThenElseAvanzato {
    public static void main(String[] args) {
        final String USERNAME = "mario";
        final String PASSWORD = "password";

        String username = JOptionPane.showInputDialog("Inserisci un username");
        String password = JOptionPane.showInputDialog("Inserisci un password");

        if(username.equals(USERNAME) && password.equals(PASSWORD)) {
            JOptionPane.showMessageDialog(null,"login effettuato");
        }
        else {
            JOptionPane.showMessageDialog(null,"credenziali incorrette");
        }
    }
}
