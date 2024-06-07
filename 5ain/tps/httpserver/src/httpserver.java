import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class httpserver {
    public static void main(String[] args) {
        int port = 80;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("HTTP Server started on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    String line;
                    while (!(line = in.readLine()).isEmpty()) {
                        System.out.println(line);
                    }

                    String htmlContent = "<body>\n" +
                                         "    <H1>Ciao mondo</H1>\n" +
                                         "    <p>tranne mancini</p>\n" +
                                         "</body>";

                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html");
                    out.println("Content-Length: " + htmlContent.length());
                    out.println();
                    out.flush();
                    out.println(htmlContent);
                } catch (IOException e) {
                    System.err.println("Connection error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
