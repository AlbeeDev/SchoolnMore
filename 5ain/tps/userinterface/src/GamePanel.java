import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
public class GamePanel extends JPanel{
    String localplayer;
    public GamePanel(JFrame frame, String localplayer){
        this.localplayer = localplayer;
        // Use BoxLayout to stack panels vertically
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        List<String> playerlist = new ArrayList<>();
        playerlist.add("player1");
        //playerlist.add("player2");
        //playerlist.add("player3");
        //playerlist.add("player4");

        frame.add(contentPane);
        List<PlayerPanel> playerPanels=new ArrayList<>();
        frame.setVisible(true);
        for (String player : playerlist) {
            PlayerPanel panel = new PlayerPanel(player,playerlist.size());
            panel.setLayout(null);
            panel.setBackground(Color.darkGray);
            panel.setMaximumSize(new Dimension(frame.getWidth()*2, frame.getHeight() / playerlist.size()));
            if(player.equals(localplayer)){
                panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "WKeyPressed");
                panel.getActionMap().put("WKeyPressed", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.gl.moveup();
                    }
                });
                panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "SKeyPressed");
                panel.getActionMap().put("SKeyPressed", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.gl.movedown();
                    }
                });
            }
            playerPanels.add(panel);
            contentPane.add(panel);

            panel.requestFocusInWindow();
        }

        Timer timer = new Timer(8, e -> {
            for(PlayerPanel pp : playerPanels){
                pp.updateroad();
                pp.repaint();
            }
        });
        timer.start();

        Timer timer2 = new Timer(10, e -> {
            for (PlayerPanel pp: playerPanels) {
                pp.advanceTransition();
            }
        });
        timer2.start();

        frame.setVisible(true);
    }
}
