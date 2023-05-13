package filemanagment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File2 {
    public File2(String filename) {
        int sum = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            for (int i = 0; i < 5; i++) {
                String line = reader.readLine();
                List<Integer> numbers = new ArrayList<Integer>();
                StringBuilder currentNumber = new StringBuilder();
                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    if (Character.isDigit(c)) {
                        currentNumber.append(c);
                    } else if (currentNumber.length() > 0) {
                        numbers.add(Integer.parseInt(currentNumber.toString()));
                        currentNumber.setLength(0);
                    }
                }
                if (currentNumber.length() > 0) {
                    numbers.add(Integer.parseInt(currentNumber.toString()));
                }
                for (int j = 0; j < numbers.size(); j++) {
                    int number = numbers.get(j);
                    sum += number;
                }
            }
            System.out.println("La somma dei numeri è: " + sum);
            reader.close();
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file!");
        }
    }
}
