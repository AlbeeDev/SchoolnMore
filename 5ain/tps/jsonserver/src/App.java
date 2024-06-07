import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;

public class App {

    

    public static void main(String[] args) throws Exception {
        
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

    static class ClientHandler extends Thread {
        private final Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        Map<String,Integer> frutta = new HashMap<>();

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            frutta.put("mele", new Random().nextInt(100));
            frutta.put("pere", new Random().nextInt(100));
            frutta.put("banane", new Random().nextInt(100));
            frutta.put("kiwi", new Random().nextInt(100));
            frutta.forEach((key, value) -> System.out.println(key + ": " + value));
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                Gson gson = new Gson();
                String message;
                while ((message = in.readLine()) != null) {
                    Frutta userfrutta = gson.fromJson(message, Frutta.class);
                    String rispostaclient;
                    if(frutta.get(userfrutta.tipo)-userfrutta.quantita>0){
                        frutta.put(userfrutta.tipo, frutta.get(userfrutta.tipo)-userfrutta.quantita);
                        
                    }
                    System.out.println("utente ha chiesto "+userfrutta.quantita+" "+userfrutta.tipo+". rimaste: "+frutta.get(userfrutta.tipo));;
                    Frutta risposta = new Frutta(userfrutta.tipo, frutta.get(userfrutta.tipo));
                    rispostaclient = gson.toJson(risposta);
                    out.println(rispostaclient);
                }

            } catch (IOException e) {
                //e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

class Frutta{
    String tipo;
    int quantita;
    Frutta(String tipo, int quantita){
        this.tipo=tipo;
        this.quantita=quantita;
    }
}
