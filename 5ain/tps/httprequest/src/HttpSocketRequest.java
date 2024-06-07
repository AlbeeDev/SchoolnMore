import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class HttpSocketRequest {
    public static void main(String[] args) {
        String hostname = "localhost";
        try (Socket socket = new Socket(hostname, 80)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("GET / HTTP/1.1");
            out.println("Host: " + hostname);
            //out.println("Connection: Close");
            out.println();
            out.flush();
            /*
            Map<String, String> headers = new HashMap<>();
            String line;
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                String[] header = line.split(": ", 2);
                headers.put(header[0], header[1]);
            }

            for(Entry<String, String> header: headers.entrySet()){
                System.out.println(header.getKey() + ": " + header.getValue());
            }
            int length=Integer.parseInt(headers.get("Content-Length"));
            System.out.println(length);
            char[] buf = new char[length];
            in.read(buf, 0, length);
            System.out.println(new String(buf));
            */
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {}
    }
}


