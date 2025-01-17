package albano.alex.es1;

import javax.swing.*;

public class TestCerchio {
    public static void main(String[] args) {
        String raggio;

        while (!(raggio = JOptionPane.showInputDialog("inserisci raggio cerchio")).matches("[\\d.-]+")){
            JOptionPane.showMessageDialog(null, "input invalido");
        }

        Cerchio c = new Cerchio(Double.parseDouble(raggio));

        JOptionPane.showMessageDialog(null, "area del cerchio: "+c.getArea()+" / circonferenza del cerchio: "+c.getCirconferenza());
    }
}
