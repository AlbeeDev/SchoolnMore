import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.*;

public class ServerSocketExample {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    
                    ObjectMapper mapper = new ObjectMapper();
                    Person person = new Person("John", 30);
                    String jsonResponse = mapper.writeValueAsString(person);

                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: application/json");
                    out.println("Content-Length: " + jsonResponse.length());
                    out.println();
                    out.println(jsonResponse);
                } catch (IOException e) {
                    System.out.println("Server exception: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
