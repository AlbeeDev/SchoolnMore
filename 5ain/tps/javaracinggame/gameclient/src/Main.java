import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
//todo compile with openjdk
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Racing game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        String localplayer = "player1";
        //GamePanel gp = new GamePanel(frame,localplayer);
        MainMenu mm = new MainMenu(frame);

        frame.setVisible(true);

    }



}