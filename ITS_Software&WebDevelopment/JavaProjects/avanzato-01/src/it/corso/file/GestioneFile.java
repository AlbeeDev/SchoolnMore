package it.corso.file;

import java.io.File;
import java.io.IOException;

public class GestioneFile {
    public static void main(String[] args) throws IOException {
        File f = new File("cartella");
        f.mkdir();

        File f1 = new File(f,"file1.txt");
        f1.createNewFile();

        File structure = new File("cartella2/sottocartella");
        structure.mkdirs();

        File f2 = new File("cartella2/sottocartella/file2.txt");
        f2.createNewFile();

        f2.renameTo(new File(structure,"file3.txt"));
    }
}
