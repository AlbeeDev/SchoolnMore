package albano.alex.es3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTelecomando {
    public static void main(String[] args) throws IOException {

        Telecomando tel = new Telecomando();
        tel.stampaTelecomando();
        System.out.println("esci con q");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!(input = br.readLine()).equals("q")) {
            tel.setLastPressed(input);
            tel.stampaTelecomando();
        }
    }
}
