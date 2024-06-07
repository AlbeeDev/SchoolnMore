import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    static Map<String, PrintWriter> clients = new ConcurrentHashMap<>();
    static Map<String,Lobby> lobbylist = new ConcurrentHashMap<>();
    static Map<String, GameSession> sessionlist = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        System.out.println("Game server started...");
        //createLobby(new Player("aaaa"));
        //createLobby(new Player("adsawd"));
        //createLobby(new Player("dawda"));
        int SERVER_PORT = 50000;
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected");
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startGame(String lobbyId, PrintWriter out){
        makeSession(lobbylist.get(lobbyId));
        System.out.println(lobbyId);
        for (Player pl : sessionlist.get(lobbyId).getPlayers()) {
            System.out.println(pl.getUsername());
        }
        String serializedPlayers;
        try {
            serializedPlayers = new ObjectMapper().writeValueAsString(sessionlist.get(lobbyId).getPlayers());
            out.println("STARTED " + sessionlist.get(lobbyId).getnumplayers() + " " + serializedPlayers);
        } catch (JsonProcessingException e) {}
        
    }

    public static synchronized void makeSession(Lobby currentlobby) {
        if (currentlobby != null) { // Check if all players are ready
            GameSession session = new GameSession(currentlobby.lobbyId, currentlobby.getPlayers());
            sessionlist.put(currentlobby.lobbyId, session);
            System.out.println("created session from id: "+currentlobby.lobbyId);
            lobbylist.remove(currentlobby.lobbyId); // Remove the lobby
            System.out.println("removed lobby with id: "+currentlobby.lobbyId);
            // Notify players, start game, etc.
        }
    }

    public static synchronized String createLobby(Player player) {
        String lobbyId = generateUniqueID(lobbylist,sessionlist); // Implement this method
        Lobby newLobby = new Lobby(lobbyId);
        newLobby.addPlayer(player);
        lobbylist.put(lobbyId, newLobby);
        System.out.println(lobbylist.get(lobbyId));
        listAllLobbies();
        System.out.println("created lobby with id: "+lobbyId);
        // Send the lobby list to the client or update the client with the new lobby
        return lobbyId;
    }

    public static synchronized void joinLobby(String lobbyId, Player player) {
        Lobby lobby = lobbylist.get(lobbyId);
        System.out.println(player.getUsername() + "tried to join "+ lobbyId);
        if (lobby != null) {
            lobby.addPlayer(player);
            System.out.println(player.getUsername() + "joined");
            // Update the clients in the lobby about the new player
        }
        // Handle the case where the lobby does not exist or is full
    }


    private static void sendAllLobbies(Socket clientSocket, PrintWriter out, BufferedReader in) {

        try {
            ObjectMapper om = new ObjectMapper();
            String lobbies = om.writeValueAsString(lobbylist);
            System.out.println(lobbies);
            out.println(lobbies);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void listAllLobbies() {
        System.out.println("Current Lobbies:");

        if (lobbylist.isEmpty()) {
            System.out.println("No lobbies available.");
            return;
        }

        for (Map.Entry<String, Lobby> entry : lobbylist.entrySet()) {
            String lobbyId = entry.getKey();
            Lobby lobby = entry.getValue();
            System.out.println("Lobby ID: " + lobbyId);
            System.out.println("Players in lobby:");

            for (Player player : lobby.getPlayers()) {
                System.out.println(" - " + player.getUsername());
            }

            System.out.println(); // Add an extra newline for separation between lobbies
        }
    }

    public static String generateUniqueID(Map<String, Lobby> lobbylist, Map<String, GameSession> sessionlist) {
        String id;
        do {
            id = generateRandomID(15);
        } while (lobbylist.containsKey(id) || sessionlist.containsKey(id));
        return id;
    }


    private static String generateRandomID(int length) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (random.nextBoolean()) {
                sb.append(alphabet[random.nextInt(alphabet.length)]);
            } else {
                sb.append(numbers[random.nextInt(numbers.length)]);
            }
        }
        return sb.toString();
    }

    private static synchronized void addClient(String username, PrintWriter out) {
        clients.put(username, out);
    }

    private static synchronized void removeClient(String username) {
        clients.remove(username);
    }

    static class ClientHandler extends Thread {
        private final Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        private String lobbyId;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                while (true) {
                    username = in.readLine();
                    if (username == null || username.trim().isEmpty()) {
                        out.println("USER_INVALID");
                        continue;
                    }
                    synchronized (Server.class) {
                        if (!clients.containsKey(username)) {
                            out.println("USER_VALID");
                            addClient(username, out);
                            System.out.println(username + " has joined.");
                            break;
                        } else {
                            out.println("USER_INVALID");
                            System.out.println("Username already in use. Try another.");
                        }
                    }
                }
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    if(message.equals("CREATE_LOBBY")){
                        System.out.println("debug: removing player");
                        removefromlobby();
                        System.out.println("debug: creating lobby");
                        lobbyId=createLobby(new Player(username));
                        System.out.println(lobbyId);
                    }
                    if (message.startsWith("JOIN_LOBBY:")) {
                        lobbyId = message.split(":")[1];
                        Lobby targetLobby = lobbylist.get(lobbyId);
                        boolean isAlreadyInTargetLobby = false;
                        if (targetLobby != null) {
                            for (Player player : targetLobby.getPlayers()) {
                                if (player.getUsername().equals(username)) {
                                    isAlreadyInTargetLobby = true;
                                    break;
                                }
                            }

                            if (!isAlreadyInTargetLobby) {
                                System.out.println("debug: removing player");
                                removefromlobby();
                                joinLobby(lobbyId, new Player(username));
                            }
                        }
                        
                    }
                    if(message.equals("GET_ALL_LOBBY")){
                        sendAllLobbies(clientSocket, out, in);
                    }

                    if(message.equals("READY")){
                        lobbylist.get(lobbyId).setPlayerReady(username, true);
                        startIfReady(lobbylist.get(lobbyId));
                    }
                    if(message.equals("UNREADY")){
                        lobbylist.get(lobbyId).setPlayerReady(username, false);
                        startIfReady(lobbylist.get(lobbyId));
                    }
                }

            } catch (IOException e) {
                //e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                removeClient(username);
                System.out.println("debug: removing player");
                removefromlobby();
                System.out.println(username + " has disconnected.");
            }
        }

        private void startIfReady(Lobby lobby) {
            for (Player player : lobby.getPlayers()) {
                if(!player.getReady()) return;
            }
            startGame(lobbyId, out);
        }

        public void removefromlobby(){
            for (Lobby lobby : lobbylist.values()) {
                Iterator<Player> playerIterator = lobby.getPlayers().iterator();
                while (playerIterator.hasNext()) {
                    Player player = playerIterator.next();
                    if (player.getUsername().equals(username)) {
                        lobby.removePlayer(player);
                        if (lobby.players.isEmpty()) {
                            lobbylist.remove(lobby.lobbyId); // Remove the lobby if it's empty
                        }
                        System.out.println(username + " removed from lobby " + lobby.getLobbyId());
                        break; // Assuming a player can only be in one lobby at a time
                    }
                }
            }
        }
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

    public boolean getReady(){
        return ready;
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

    public synchronized void setPlayerReady(String playerName, boolean ready) {
        for (Player player : players) {
            if (player.getUsername().equals(playerName)) { // Assuming there's a getName() method
                System.out.println(playerName+" is ready: "+ready);
                player.setReady(ready);
                break;
            }
        }
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