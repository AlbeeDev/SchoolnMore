import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LobbyMenu extends JPanel {

    JButton createlobby;
    JButton startgame;
    JButton backbutton;

    public LobbyMenu(JFrame frame, String localplayer, Socket socket, PrintWriter out, BufferedReader in){
        frame.add(this);
        setLayout(null);
        ConcurrentHashMap<String, Lobby> lobbylist= getlobbies(out, in);

        LobbyListPanel lobbyListPanel = new LobbyListPanel(lobbylist,socket);
        JScrollPane scrollPane = new JScrollPane(lobbyListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0,0,700,500);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        add(scrollPane);


        //todo make the request for the list of lobbies and make the interface of the lobbymenu
        createlobby=new JButton("Create lobby");
        createlobby.setBounds(800,500,150,50);
        createlobby.setBackground(Color.green);
        createlobby.setFont(new Font("",Font.PLAIN,20));
        add(createlobby);

        ActionListener cl = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    out.println("CREATE_LOBBY");
                    ConcurrentHashMap<String, Lobby> updatedLobbyList = getlobbies(out, in);

                    // Updating the UI on the Event Dispatch Thread
                    SwingUtilities.invokeLater(() -> {
                        lobbyListPanel.updateLobbyList(updatedLobbyList);
                        lobbyListPanel.revalidate();
                        lobbyListPanel.repaint();
                    });
                }).start();
            }
        };

        createlobby.addActionListener(cl);

        startgame= new JButton("Start game");
        startgame.setBounds(800,400,150,50);
        startgame.setBackground(Color.green);
        startgame.setFont(new Font("",Font.PLAIN,20));
        add(startgame);


        startgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println("READY");
                JDialog dialog = new JDialog(frame, "Custom Dialog", true);
    
                // Create a panel to hold the components
                JPanel panel = new JPanel(new BorderLayout());
        
                // Create a label
                JLabel label = new JLabel("Waiting for user action...");
                panel.add(label, BorderLayout.CENTER);
        
                // Create an "OK" button
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle the "OK" button click here
                        label.setText("You clicked OK");
                        // Close the dialog
                        dialog.dispose();
                    }
                });
        
                // Create a "Cancel" button
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle the "Cancel" button click here
                        out.println("UNREADY");
                        // Close the dialog
                        dialog.dispose();
                    }
                });
        
                // Create a panel to hold the buttons
                JPanel buttonPanel = new JPanel();
                buttonPanel.add(cancelButton);
                panel.add(buttonPanel, BorderLayout.SOUTH);
        
                dialog.add(panel);
                dialog.setSize(300, 150);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(frame, "This is a dialog box!", "Dialog Box", JOptionPane.INFORMATION_MESSAGE);
                /* 
                out.println("START_GAME");

                String response = null;
                try {
                    response = in.readLine();
                    if(response.startsWith("STARTED")){
                        String[] parts = response.split(" ");
                        if (parts.length >= 2) {
                            int numberOfPlayers = Integer.parseInt(parts[1]);
                            String serializedPlayers = parts[2];
                            List<Player> players = new ObjectMapper().readValue(serializedPlayers, new TypeReference<List<Player>>(){});
                            GamePanel gp = new GamePanel(frame, localplayer, numberOfPlayers, players);
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                */
            }
        });

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(800, 10, 150, 50); // Adjust the position and size as needed
        add(refreshButton);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConcurrentHashMap<String, Lobby> updatedLobbyList = getlobbies(out, in);
                lobbyListPanel.updateLobbyList(updatedLobbyList);
            }
        });

    }

    public ConcurrentHashMap<String, Lobby> getlobbies(PrintWriter out, BufferedReader in){
        try{
            ObjectMapper om = new ObjectMapper();
            out.println("GET_ALL_LOBBY");
            String objresponse = in.readLine();
            System.out.println(objresponse);
            //si usa typereference per i tipi "non-classe"
            TypeReference<ConcurrentHashMap<String, Lobby>> typeRef = new TypeReference<ConcurrentHashMap<String, Lobby>>() {};
            return om.readValue(objresponse, typeRef);
        }catch (Exception e){
            System.out.println("error in getting list");
        }
        return null;
    }
}

class LobbyListPanel extends JPanel {
    private Socket socket; // Store socket for reuse in update

    public LobbyListPanel(ConcurrentHashMap<String, Lobby> lobbies, Socket socket) {
        this.socket = socket; // Save the socket for later
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Stack vertically
        addLobbies(lobbies);
    }

    private void addLobbies(ConcurrentHashMap<String, Lobby> lobbies) {
        for (Map.Entry<String, Lobby> lobby : lobbies.entrySet()) {
            LobbyPane lobbyPane = new LobbyPane(lobby.getKey(), lobby.getValue(), socket);
            lobbyPane.setAlignmentX(Component.LEFT_ALIGNMENT); // Align each lobby pane to the left
            add(lobbyPane);
            add(Box.createVerticalStrut(30));
        }
    }

    public void updateLobbyList(ConcurrentHashMap<String, Lobby> updatedLobbies) {
        removeAll(); // Remove all existing components
        addLobbies(updatedLobbies); // Add new lobby panes
        revalidate(); // Refresh layout
        repaint(); // Refresh display
    }
}

class LobbyPane extends JPanel {
    private JLabel lobbyidfield;
    private JLabel playernumfield;
    private JLabel playersfield;
    private JButton joinButton;

    public LobbyPane(String lobbyId, Lobby lobbyinfo, Socket socket) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Horizontal layout for contents of LobbyPane
        setBackground(Color.pink);
        add(Box.createVerticalStrut(10));
        lobbyidfield = new JLabel("Lobby ID: " + lobbyId);
        add(lobbyidfield);
        add(Box.createVerticalStrut(30));
        playernumfield = new JLabel("Player count: " + lobbyinfo.getnumplayers());
        add(playernumfield);
        add(Box.createVerticalStrut(30));
        playersfield = new JLabel();
        StringBuilder sb = new StringBuilder();
        sb.append("players: ");
        for(Player user:lobbyinfo.players){
            sb.append(user.getUsername()+", ");
        }
        playersfield.setText(sb.toString());
        add(playersfield);
        add(Box.createVerticalStrut(30));
        joinButton = new JButton("Join");
        add(Box.createVerticalStrut(10));
        add(joinButton);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Enable auto-flush
                    out.println("JOIN_LOBBY:" + lobbyId);
                    System.out.println("Joined lobby: " + lobbyId);
                } catch (IOException e1) {

                }
            }
        };

        joinButton.addActionListener(al);
    }
}

class Lobby{
    String lobbyId;
    List<Player> players;
    int numplayers;
    @JsonCreator
    public Lobby(@JsonProperty("lobbyId") String lobbyId) {
        this.lobbyId = lobbyId;
        this.players = new ArrayList<>();
    }

    public void setLobbyId(String lobbyId) {
        this.lobbyId = lobbyId;
    }

    public String getLobbyId() {
        return lobbyId;
    }
    public void setNumplayers(int numplayers) {
        this.numplayers = numplayers;
    }
    public int getnumplayers() {
        return players.size();
    }
    @JsonProperty("players")
    public synchronized void setPlayers(List<Player> players) {
        this.players = new ArrayList<>(players);
    }
    public synchronized List<Player> getPlayers() {
        return new ArrayList<>(players); // Return a copy to avoid concurrent modification
    }
    public synchronized void addPlayer(Player player) {
        players.add(player);
    }
    public synchronized void removePlayer(Player player) {
        players.remove(player);
    }

}
class Player{
    private String username;
    private Boolean ready;

    @JsonCreator
    public Player(@JsonProperty("username") String username) {
        this.username = username;
        ready=false;
    }

    public String getUsername() {
        return username;
    }

    public void setReady(boolean state){
        ready=state;
    }
}
