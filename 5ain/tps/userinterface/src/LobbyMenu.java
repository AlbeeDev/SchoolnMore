import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LobbyMenu extends JPanel {

    JButton createlobby;
    JButton backbutton;

    ObjectInputStream in2;
    public LobbyMenu(JFrame frame, Socket socket, PrintWriter out, BufferedReader in){
        frame.add(this);
        setLayout(null);
        ConcurrentHashMap<String, Lobby> lobbylist= new ConcurrentHashMap<>();
        //todo solve input stream problem
        try{
            in.close();
            System.out.println("error");
            in2= new ObjectInputStream(socket.getInputStream());
            System.out.println("error");
            out.println("GET_ALL_LOBBY");
            System.out.println("error");
            lobbylist = (ConcurrentHashMap<String, Lobby>) in2.readObject();
        }catch (Exception e){
            System.out.println("error in getting list");
            e.printStackTrace();
        }




        LobbyListPanel lobbyListPanel = new LobbyListPanel(lobbylist);
        JScrollPane scrollPane = new JScrollPane(lobbyListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
                out.println("CREATE_LOBBY");
            }
        };

        createlobby.addActionListener(cl);




    }
}

class LobbyListPanel extends JPanel {
    public LobbyListPanel(ConcurrentHashMap<String, Lobby> lobbies) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Stack vertically
        for (Entry<String, Lobby> lobby : lobbies.entrySet()) {
            add(new LobbyPane(lobby.getKey(),lobby.getValue().getnumplayers()));
            //lobby.setAlignmentX(Component.LEFT_ALIGNMENT); // Align each lobby pane to the left
        }
    }
}

class LobbyPane extends JPanel{
    JLabel lobby_info;
    JLabel joinbutton;

    LobbyPane(String lobby_id,int playercount){
        setBackground(Color.pink);

        lobby_info.setBounds(0,0,100,100);
        lobby_info.setText("players: "+playercount);
        add(lobby_info);

        //joinbutton.setBounds();
    }
}

class Lobby implements Serializable {
    private final String lobbyId;
    private final List<Player> players;

    public Lobby(String lobbyId) {
        this.lobbyId = lobbyId;
        this.players = new ArrayList<>();
    }

    public String getLobbyId() {
        return lobbyId;
    }

    public int getnumplayers() {
        return players.size();
    }
}
class Player implements Serializable{
    private final String username;

    public Player(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
