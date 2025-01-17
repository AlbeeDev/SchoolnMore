package it.corso.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class lettura {
    public static void main(String[] args) {
        //leggiperriga();
        leggipercarattere();
    }

    static void leggiperriga(){
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line=br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void leggipercarattere(){
        try (FileReader fileReader = new FileReader("file.txt")){
            StringBuilder sb = new StringBuilder();
            int character;
            while ((character = fileReader.read()) != -1) {
                sb.append((char) character);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
