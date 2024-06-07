import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MioClient {

    public static void main(String[] args) {
        String serverAddress = "172.16.38.17"; //138
        
        int port = 50000;
        for(int i=30;i<39;i++){
            for(int j=1;j<255;j++){
                try {
            StringBuilder sb = new StringBuilder();
            sb.append("172.");
            sb.append("16.");
            sb.append(i+".");
            sb.append(j);
            //System.out.println("trying to connect to "+sb.toString());
            String currentaddress= sb.toString();
            //Socket socket = new Socket(currentaddress, port);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(serverAddress, port), 10);
            socket.setSoTimeout(10);
            //System.out.println("Connected to the server.");

            // Reader and Writer for communication
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // 'true' to auto-flush after write

            // Read the message from the server
            String serverMessage = br.readLine();
            pw.println("Daje Roma!");
            System.out.println("Server "+serverAddress+" says: " + serverMessage);

            // Send a response back to the server
            

            // Cleanup resources
            socket.close();
            break;
            //System.out.println("Disconnected from the server.");
        } catch (IOException e) {
            //System.err.println("Error communicating with the server: " + e.getMessage());
        }
            }
            
        }
        
    }
}