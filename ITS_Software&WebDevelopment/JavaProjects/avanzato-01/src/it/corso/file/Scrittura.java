package it.corso.file;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scrittura {
    public static void main(String[] args) {
        //scrivisufile("ciao mondo");
        aggiungiafile("seconda riga");
    }

    static void scrivisufile(String testo){
        try (PrintWriter pw = new PrintWriter("file.txt")){
            pw.println(testo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void aggiungiafile(String testo){
        try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt", true))) {
            pw.println(testo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
