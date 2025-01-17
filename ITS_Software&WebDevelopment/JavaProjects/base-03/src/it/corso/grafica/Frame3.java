package it.corso.grafica;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Frame3 extends JFrame {
    Map<String, String[]> mapmenu = new LinkedHashMap<>();

    {
        mapmenu.put("file", new String[]{"nuovo","salva","salva con nome"});
        mapmenu.put("modifica", new String[]{"seleziona","elimina"});
    }

    public Frame3() {
        setTitle("Frame3");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0,0);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setJMenuBar(makemenubar());

        setVisible(true);
    }

    public JMenuBar makemenubar(){
        JMenuBar menuBar = new JMenuBar();
        for (String nomemenu : mapmenu.keySet()) {
            JMenu menu = new JMenu(nomemenu);
            for(String itemname : mapmenu.get(nomemenu)) {
                JMenuItem item = new JMenuItem(itemname);
                item.setActionCommand(itemname);
                menu.add(item);
            }
            menuBar.add(menu);
        }

        return menuBar;
    }

    public static void main(String[] args) {
        new Frame3();
    }
}
