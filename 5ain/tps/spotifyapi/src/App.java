import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    static String CLIENT_ID="8d567ec874ef4d759349dd27dd08229f";
    static String CLIENT_SECRET="a63d1de1eace4628b88cc90be9e06abb";
    public static void main(String[] args) {
        try {
            //write to json
            Token token =gettoken();
            getprofile(token);
            

            
            /* formal method
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://accounts.spotify.com/api/token"))
                    .header("Content-Type", "application/spotifyapp")
                    .header("Authorization", "Basic " + encodedCredentials)
                    .POST(BodyPublishers.ofString("grant_type=client_credentials"))
                    .build();
            
            /*
            // Set the HTTP request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            System.out.println(connection.getHeaderField(0));

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Entry<String, List<String>> hd : headers.entrySet()) {
                System.out.println(hd.getKey()+"  "+hd.getValue());
            }
            /*
            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Print the HTML content of the page
            System.out.println("HTML Content:");
            System.out.println(response.toString());
            */
            // Close the connection
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public static Token gettoken(){
        try {
            URL url = new URL("https://accounts.spotify.com/api/token");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String encodedCredentials = encodeClientCredentials(CLIENT_ID, CLIENT_SECRET);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            
            
            String parameters = "grant_type=client_credentials";
            try (PrintWriter out = new PrintWriter(connection.getOutputStream())) {
                out.print(parameters);
            }
            
            //read from input stream
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }            

            connection.disconnect();
            ObjectMapper om = new ObjectMapper();
            Token token = om.readValue(response.toString(), Token.class);
            return token;
        } catch (Exception e) {
            
        }
        return null;
    }

    public static String getprofile(Token token){
        try {
            URL url = new URL("https://api.spotify.com/v1/me");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + token.getAccess_token());
            connection.setDoOutput(true);

            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }    

            System.out.println(response.toString());
            connection.disconnect();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public static String encodeClientCredentials(String clientId, String clientSecret) {
        String credentials = clientId + ":" + clientSecret;
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }
}
