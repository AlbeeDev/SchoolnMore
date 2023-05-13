package filemanagment;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File3 {
    public File3(String filename) {
        int sum = 0;
        try {
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filename));
            for (int i = 0; i < 5; i++) {
                int data = reader.read();
                List<Integer> numbers = new ArrayList<Integer>();
                StringBuilder currentNumber = new StringBuilder();
                while (data != -1) {
                    char c = (char) data;
                    if (Character.isDigit(c)) {
                        currentNumber.append(c);
                    } else if (currentNumber.length() > 0) {
                        numbers.add(Integer.parseInt(currentNumber.toString()));
                        currentNumber.setLength(0);
                    }
                    data = reader.read();
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
