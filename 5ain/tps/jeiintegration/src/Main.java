import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static String modid;
    public static void main(String[] args) {
        modid="create";
        extractRecipes("src/"+modid+".jar","");
        RecipeParser rp = new RecipeParser("andesite_alloy");
        Recipe rec = rp.getRecipe();
        for(Map.Entry<String, Ingredient> en : rec.getKey().entrySet()){
            System.out.println(en.getKey()+" "+en.getValue().getItem()+" "+en.getValue().getTag());
        }
        System.out.println(Arrays.asList(rec.getPattern()));
    }

    public static String extractFileName(String filePath) {
        // Extract the part after the last '/' character
        String fileNameWithExtension = filePath.substring(filePath.lastIndexOf("/") + 1);

        // Remove the file extension
        String fileName = fileNameWithExtension.substring(0, fileNameWithExtension.lastIndexOf("."));

        return fileName;
    }

    public static boolean checkForRecipeFiles(String jarFilePath) {
        try {
            // Create input stream to read from the .jar file
            ZipInputStream zis = new ZipInputStream(new FileInputStream(jarFilePath));
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                String fileName = zipEntry.getName();

                // Check if fileName matches the condition
                if (fileName.contains("recipes/crafting") && fileName.endsWith(".json")) {
                    zis.close(); // Make sure to close the stream before returning
                    return true; // Match found, return true
                }
                zipEntry = zis.getNextEntry(); // Continue checking next entries
            }
            zis.close(); // Make sure to close the stream after finishing the loop
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // No matches found, return false
    }

    public static void extractRecipes(String jarFilePath, String outputDirPath) {
        byte[] buffer = new byte[1024];
        try {
            // Create input stream to read from the .jar file
            ZipInputStream zis = new ZipInputStream(new FileInputStream(jarFilePath));
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                String fileName = zipEntry.getName();

                // Filter and extract only JSON files (likely to be recipes)
                if (fileName.contains(modid+"/recipes") && fileName.endsWith(".json")) {
                    // Construct output file path
                    //System.out.println(fileName);
                    System.out.println(extractFileName(fileName));
                    String outputFile = outputDirPath + fileName;
                    // Create all non-existent parent directories of the output file
                    new File(outputFile).getParentFile().mkdirs();
                    FileOutputStream fos = new FileOutputStream(outputFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}