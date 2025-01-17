package it.corso.grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Frame2 extends JFrame implements ActionListener {

    List<JCheckBox> checkBoxList = new ArrayList<>();
    List<JRadioButton> radioButtonList = new ArrayList<>();
    ButtonGroup radiogroup = new ButtonGroup();

    public Frame2() {
        setTitle("Frame2");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.add(getPanel());

        setVisible(true);
    }

    private JPanel getPanel(){
        JPanel panel = new JPanel(null);
        JCheckBox checkBox = new JCheckBox("seleziona");
        checkBox.setActionCommand("seleziona");
        checkBox.addActionListener(this);
        checkBox.setBounds(10,10,200,20);
        panel.add(checkBox);
        JButton pulsante = new JButton();

        createCheckbox(50,"opzione1","opzione2");
        createRadioButton(10,"uomo","donna");

        for (JCheckBox c : checkBoxList){
            panel.add(c);
        }
        for (JRadioButton r : radioButtonList){
            panel.add(r);
        }

        pulsante.addActionListener(this);
        pulsante.setBounds(10,10,200,20);
        panel.add(pulsante);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("seleziona")){
            JCheckBox c = (JCheckBox)e.getSource();
            if(c.isSelected()){
                System.out.println("selezionato");
            } else {
                System.out.println("non selezionato");
            }
        }
    }

    public void createCheckbox(int posY, String... testi){
        for (String testo : testi) {
            JCheckBox c = new JCheckBox(testo);
            c.setActionCommand(testo);
            c.addActionListener(this);
            c.setBounds(10,posY,200,20);
            posY+=20;
            checkBoxList.add(c);
        }
    }

    public void createRadioButton(int posX, String... testi){
        for (String testo : testi) {
            JRadioButton radio = new JRadioButton(testo);
            radio.setActionCommand(testo);
            radio.addActionListener(this);
            radio.setBounds(posX,150,70,20);
            radiogroup.add(radio);
            radioButtonList.add(radio);
            posX+=70;

        }
    }

    public static void main(String[] args) {
        new Frame2();
    }
}
