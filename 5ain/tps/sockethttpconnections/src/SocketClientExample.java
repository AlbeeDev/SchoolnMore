import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.*;

public class SocketClientExample {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(hostname, port)) {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // Sending HTTP GET request
            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + hostname);
            writer.println("Connection: Close");
            writer.println();

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(response.toString(), Person.class);
            System.out.println("Received: " + person.getName() + ", Age: " + person.getAge());

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}