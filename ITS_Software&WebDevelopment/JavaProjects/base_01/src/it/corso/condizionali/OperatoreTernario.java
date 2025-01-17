package it.corso.condizionali;

import javax.swing.*;

public class OperatoreTernario {
    public static void main(String[] args) {
        int eta = Integer.parseInt(JOptionPane.showInputDialog("inserisci la tua eta"));

        JOptionPane.showMessageDialog(null,(eta >= 18) ? "maggiorenne":"non maggiorenne");

    }
}
