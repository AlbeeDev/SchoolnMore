import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    static Map<String, PrintWriter> clientWriters = new HashMap<>();
    public static void main(String[] args) throws Exception {
        System.out.println("Chat server started...");
        int SERVER_PORT = 50000;
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true){
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void broadcastMessage(String username, String message) {
        for (Map.Entry<String, PrintWriter> entry : clientWriters.entrySet()) {
            if (!entry.getKey().equals(username)) {  // Skip sending the message to the sender
                entry.getValue().println(message);
            }
            else {
                entry.getValue().println(message);
            }
        }
    }

    private static synchronized void addClient(String username, PrintWriter out) {
        clientWriters.put(username, out);
    }

    private static synchronized void removeClient(String username) {
        clientWriters.remove(username);
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
                    out.println("Enter your username:");
                    username = in.readLine();
                    if (username == null || username.trim().isEmpty()) {
                        out.println("Invalid username. Try again.");
                        continue;
                    }
                    synchronized (Server.class) {
                        if (!clientWriters.containsKey(username)) {
                            addClient(username, out);
                            out.println("Username accepted!");
                            System.out.println(username + " has joined.");
                            broadcastMessage(username, username + " has joined.");
                            break;
                        } else {
                            out.println("Username already in use. Try another.");
                        }
                    }
                }
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcastMessage(username,username + ": " + message);
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
                broadcastMessage(username, username + " has disconnected.");
            }
        }
    }

}



