import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    static Map<String, PrintWriter> clients = new ConcurrentHashMap<>();
    static Map<String,Lobby> lobbylist = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        System.out.println("Game server started...");
        createLobby(new Player("aaaa"));
        createLobby(new Player("adsawd"));
        createLobby(new Player("dawda"));
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

    public static void createLobby(Player player) {
        String lobbyId = generateUniqueID(lobbylist); // Implement this method
        Lobby newLobby = new Lobby(lobbyId);
        newLobby.addPlayer(player);
        lobbylist.put(lobbyId, newLobby);
        System.out.println("created lobby with id: "+lobbyId);
        // Send the lobby list to the client or update the client with the new lobby
    }

    public static void joinLobby(String lobbyId, Player player) {
        Lobby lobby = lobbylist.get(lobbyId);
        if (lobby != null) {
            lobby.addPlayer(player);
            // Update the clients in the lobby about the new player
        }
        // Handle the case where the lobby does not exist or is full
    }


    private static void sendAllLobbies(Socket clientSocket) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(new ConcurrentHashMap<>(lobbylist));  // Make a copy to serialize
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateUniqueID(Map<String, Lobby> lobbyMap) {
        String id;
        do {
            id = generateRandomID(15);
        } while (lobbyMap.containsKey(id));
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
                        System.out.println("debug: creating lobby");
                        createLobby(new Player(username));
                    }
                    if (message.startsWith("JOIN_LOBBY:")) {
                        String lobbyId = message.split(":")[1];
                        //todo make the right request in the client ^^^
                        Server.joinLobby(lobbyId, new Player(username));
                    }
                    if(message.equals("GET_ALL_LOBBY")){
                        sendAllLobbies(clientSocket);
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
                System.out.println(username + " has disconnected.");
            }
        }


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

    public int getnumplayers(){
        return  players.size();
    }

    public synchronized List<Player> getPlayers() {
        return new ArrayList<>(players); // Return a copy to avoid concurrent modification
    }

    public synchronized void addPlayer(Player player) {
        players.add(player);
    }

    // Other methods like removePlayer, isFull, startGame, etc.
}