import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyMain {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Integer> Talents = new HashMap<String, Integer>();
        try {
        	Talents = objectMapper.readValue(new File("src/Profile.json"), Map.class);
            //System.out.print(Talents);
            for (Map.Entry<String, Integer> entry : Talents.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}