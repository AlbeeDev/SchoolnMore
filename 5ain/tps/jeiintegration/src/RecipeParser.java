import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class RecipeParser {
    String filePath;

    public RecipeParser(String filepath) {
        this.filePath=getpathfromitem("src/create.jar",filepath);
        System.out.println(this.filePath);
    }

    public Recipe getRecipe() {
        String jsonContent;
        Recipe recipe = null;
        try {
            jsonContent = readFileToString(filePath);
            ObjectMapper om = new ObjectMapper();
            recipe = om.readValue(jsonContent, Recipe.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return recipe;
    }

    public static String getpathfromitem(String jar,String filepath) {
        try {
            // Create input stream to read from the .jar file
            ZipInputStream zis = new ZipInputStream(new FileInputStream(jar));
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                String fileName = zipEntry.getName();

                // Check if fileName matches the condition
                if (fileName.contains("recipes/crafting") && fileName.endsWith("/"+filepath+".json")) {
                    zis.close(); // Make sure to close the stream before returning
                    return fileName;
                }
                zipEntry = zis.getNextEntry(); // Continue checking next entries
            }
            zis.close(); // Make sure to close the stream after finishing the loop
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void parseRecipe(String json) {
        ObjectMapper om = new ObjectMapper();
        Recipe recipe = null;
        try {
            recipe = om.readValue(json, Recipe.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Recipe Type: " + recipe.type);
        System.out.println("Result Item: " + recipe.result.item);

        recipe.key.forEach((key, value) -> {
            if (value.item != null) {
                System.out.println(key + " -> Item: " + value.item);
            } else if (value.tag != null) {
                System.out.println(key + " -> Tag: " + value.tag);
            }
        });
    }

    public static String readFileToString(String filePath) throws Exception {
        // Read file content into a String
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }


}