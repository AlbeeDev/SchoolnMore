package albano.alex.es2;

import javax.swing.*;

public class TestUtente {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("inserisci nome");
        String cognome = JOptionPane.showInputDialog("inserisci cognome");

        Utente utente = new Utente(nome, cognome);
        utente.genPassword();

        JOptionPane.showMessageDialog(null, "la tua password è "+utente.getPassword());
    }
}
