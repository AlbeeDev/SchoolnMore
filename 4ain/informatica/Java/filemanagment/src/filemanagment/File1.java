package filemanagment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class File1 {
    String filename;
    public File1(String filename) {
    	this.filename=filename;
        try {
            FileWriter writer = new FileWriter(filename);
            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    int num = rand.nextInt(50);
                    writer.write(num + " ");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Numbers written to file successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
