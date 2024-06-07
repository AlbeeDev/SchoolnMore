import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

import com.google.gson.Gson;


public class App {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 50000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Gson gson = new Gson();
        Frutta userfrutta = new Frutta("mele", 10);
        String clientrequest = gson.toJson(userfrutta);
        out.println(clientrequest);

        String serverMessage;

        while ((serverMessage = in.readLine()) != null) {
            System.out.println(serverMessage);
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
