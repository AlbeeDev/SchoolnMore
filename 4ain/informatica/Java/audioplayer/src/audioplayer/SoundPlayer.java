package audioplayer;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SoundPlayer extends JFrame {
    private Clip clip;
    private JButton playButton;

    public SoundPlayer() {
        setTitle("Sound Player");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File soundFile = new File("beat 2.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                	System.out.println(ex.toString());
                    ex.printStackTrace();
                }
            }
        });

        add(playButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SoundPlayer player = new SoundPlayer();
            player.setVisible(true);
        });
    }
}
