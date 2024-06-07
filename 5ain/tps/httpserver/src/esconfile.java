import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class esconfile {
    public static void main(String[] args) {
        int port = 80;
        File htmlFile = new File("index.html");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("HTTP Server started on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    // Read the request (though we're not doing anything with it here)
                    String line;
                    while (!(line = in.readLine()).isEmpty()) {
                        System.out.println(line);
                    }

                    // Serve the index.html file
                    if (htmlFile.exists() && !htmlFile.isDirectory()) {
                        out.println("HTTP/1.1 200 OK");
                        out.println("Content-Type: text/html");
                        out.println("Content-Length: " + htmlFile.length());
                        out.println();
                        out.flush();

                        sendFile(clientSocket.getOutputStream(), htmlFile);
                    } else {
                        out.println("HTTP/1.1 404 Not Found");
                        out.println();
                    }
                } catch (IOException e) {
                    System.err.println("Connection error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static void sendFile(OutputStream outputStream, File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        }
    }
}
