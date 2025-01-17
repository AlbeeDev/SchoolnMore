package it.corso.input;

import javax.swing.*;
import java.awt.*;

public class InputGrafico {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("inserisci il tuo nome");
        String cognome = JOptionPane.showInputDialog("inserisci il cognome");
        int eta = Integer.parseInt(JOptionPane.showInputDialog("inserisci l' eta"));

        JOptionPane.showMessageDialog(null, "nome: " + name + " cognome: " + cognome + " eta: " + eta);
        //System.out.println("nome: " + name + " cognome: " + cognome + " eta: " + eta);
    }
}
