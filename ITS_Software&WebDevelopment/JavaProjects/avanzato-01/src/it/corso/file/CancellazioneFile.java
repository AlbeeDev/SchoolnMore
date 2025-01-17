package it.corso.file;

import java.io.File;

public class CancellazioneFile {
    public static void main(String[] args) {
        File file1 = new File("cartella/file1.txt");
        File cartella = new File("cartella");
        File cartella2 = new File("cartella2");

        file1.delete();
        cartella.delete();
        cartella2.delete();

        cancellastruttura(cartella2);
    }

    static void cancellastruttura(File directory){
        File[] files = directory.listFiles();
        for(File file : files){
            if(file.isFile()){
                file.delete();
            }else {
                cancellastruttura(file);
            }
        }
        directory.delete();
    }

}
