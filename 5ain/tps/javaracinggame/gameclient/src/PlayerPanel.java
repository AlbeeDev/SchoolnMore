import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayerPanel extends JPanel {
    GameLogic gl;
    String player;
    Image carmodel;
    Image roadmodel;
    Image barriermodel;
    Image conemodel;
    private int imageWidth;
    int[] imagePositions;
    private final int scrollSpeed = 10;
    private float transitionProgress = 0.0f;
    private float increasespeed = 0.02f;
    int sizefactor = 300;
    int lobbysize=1;
    public PlayerPanel(String playername, int lobby) {
        gl = new GameLogic();
        setFocusable(true);
        lobbysize=lobby;
        JPanel[] nameareas = new JPanel[lobbysize];
        for (int i=0;i<lobbysize;i++){
            nameareas[i]=new JPanel();
            JLabel lb = new JLabel(playername);
            lb.setBounds(0,0,20,10);
            nameareas[i].add(lb);
            add(nameareas[i]);
        }

        sizefactor = sizefactor/lobbysize;
        try {
            carmodel =ImageIO.read(new File("src/carmodel.png"));
            barriermodel =ImageIO.read(new File("src/obstacle2.png"));
            conemodel =ImageIO.read(new File("src/obstacle1.png"));
        } catch (Exception e){
            System.out.println("image not found");
        }
        carmodel = carmodel.getScaledInstance(sizefactor,sizefactor,Image.SCALE_SMOOTH);
        barriermodel = barriermodel.getScaledInstance(sizefactor,sizefactor,Image.SCALE_SMOOTH);
        conemodel = conemodel.getScaledInstance(sizefactor,sizefactor,Image.SCALE_SMOOTH);

        try {
            roadmodel = ImageIO.read(new File("src/roadmodel2.png"));
            roadmodel = roadmodel.getScaledInstance(1180/lobbysize, 1180/lobbysize, Image.SCALE_SMOOTH);
            imageWidth = roadmodel.getWidth(null);

            // Number of images you want to manage
            int numImages = 3*lobbysize;
            imagePositions = new int[numImages];

            // Initialize positions
            for (int i = 0; i < numImages; i++) {
                imagePositions[i] = i * imageWidth;
            }



        } catch (IOException ex) {
            ex.printStackTrace();
        }



        requestFocusInWindow();

    }
    public void updateroad(){
        for (int i = 0; i < imagePositions.length; i++) {
            imagePositions[i] -= scrollSpeed;

            // Check boundary and reset position
            if (imagePositions[i] <= -imageWidth) {
                int rightmostPos = findRightmostPosition();
                imagePositions[i] = rightmostPos + imageWidth - 10;  // overlapOffset is the amount of pixels to overlap
            }
        }
    }

    private int findRightmostPosition() {
        int max = Integer.MIN_VALUE;
        for (int pos : imagePositions) {
            if (pos > max) {
                max = pos;
            }
        }
        return max;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dashed line settings
        int dashLength = 30;  // Length of each dash
        int spaceLength = 15; // Space between dashes
        int totalLength = dashLength + spaceLength;
        int[] laneOffsets = {-50/lobbysize, 0, 50/lobbysize};
        int obstacleoffset = (int) (getWidth()*4 / gl.gamematrix[0].length * transitionProgress);

        g.setColor(Color.white);

        // Draw the top dashed line
        for (int x = 0; x < getWidth(); x += totalLength) {
            g.drawLine(x, getHeight() / 3, x + 30, getHeight() / 3);
        }

        // Draw the bottom dashed line
        for (int x = 0; x < getWidth(); x += totalLength) {
            g.drawLine(x, getHeight() / 3 * 2, x + 30, getHeight() / 3 * 2);
        }
        g.setColor(Color.red);
        g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        g.setColor(Color.white);
        // Draw the image
        for (int imagePosition : imagePositions) {
            g.drawImage(roadmodel, imagePosition, 0, null);
        }

        for(int i=0;i<gl.gamematrix.length;i++){
            for(int j=0;j<gl.gamematrix[0].length;j++){
                if(gl.gamematrix[i][j]==2){
                    g.drawImage(barriermodel,getWidth()*4 / gl.gamematrix[0].length * j + sizefactor/2  - obstacleoffset, (getHeight() / 2 - sizefactor / 2 * (1-i+1)) + laneOffsets[i], null);
                }

            }
        }

        g.drawImage(carmodel, getWidth() / 6- sizefactor/2, (getHeight() / 2 - sizefactor / 2 * (1-gl.playerx+1)) + laneOffsets[gl.playerx], null);
    }

    public void advanceTransition() {
        transitionProgress += 0.015f; //todo fun idea to make it faster every time
        if (transitionProgress >= 1.0f) {
            transitionProgress = 0.0f;
            gl.generatenewcols(gl.gamematrix); //todo watch out for server implementation of timer
            gl.printmatrix();
        }
        repaint();
    }

}
