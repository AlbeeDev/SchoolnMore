import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONWriter;

public class WriteJson {

    public static void main(String[] args) {

        // Create a JSON object
        JSONObject obj = new JSONObject();
        
        try {
        	obj.put("name", "John");
            obj.put("age", 30);
            obj.put("city", "New York");
        }catch(Exception e) {
        	e.printStackTrace();
        }
        

        // Write the JSON object to a file
        try (FileWriter file = new FileWriter("src/data.json")) {
            file.write(obj.toString(4));
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}