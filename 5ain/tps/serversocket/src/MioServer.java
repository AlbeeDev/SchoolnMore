import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MioServer {

    public static void main(String[] args) throws Exception {
        int port = 50000;
        ServerSocket serverconn = new ServerSocket(port);

        while (true) {
            System.out.println("Server in attesa");
            Socket clientconn = serverconn.accept();
            System.out.println("Server arrivato cliente");

            // Start a new thread to handle the client connection
            ClientHandler clientHandler = new ClientHandler(clientconn);
            Thread thread = new Thread(clientHandler);
            thread.start();
			serverconn.setSoTimeout(5000);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

            pw.println("Benvenuto in calabria!");
            String risposta = br.readLine();
            System.out.println("Client says: " + risposta);

            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}
