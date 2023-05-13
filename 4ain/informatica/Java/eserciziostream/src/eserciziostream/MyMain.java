package eserciziostream;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class MyMain {

	public static void main(String[] args) {
		String[] s = new String[]{"carlo daje","fabrizio roma","gianluca forza","maurizio lupi"};
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("src/fileBinario.bin"))) {
            Random r = new Random();
        	for(int i=0;i<s.length;i++) {
            	outputStream.writeInt(i+1);
                outputStream.writeInt(r.nextInt(2,10));
                outputStream.writeInt(r.nextInt(2,10));
                outputStream.writeInt(r.nextInt(2,10));
                outputStream.writeInt(r.nextInt(2,10));
                double mark = Double.parseDouble(new DecimalFormat("#,##").format(r.nextDouble(2.0,10.0)));
                outputStream.writeDouble(mark);
            }
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (PrintWriter pw = new PrintWriter("src/fileTesto.txt")){
        	for(int i=0;i<s.length;i++) {
        		pw.print(i+1);
        		pw.print(" "+s[i]);
        		pw.print('\n');
        	}
        }catch(Exception e) {
        	
        }
        double media =0;
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream("src/fileBinario.bin"))) {
        	try (Scanner sc = new Scanner(new File("src/fileTesto.txt"))){
        		for(int i=0;i<s.length;i++) {
        			int intValue1 = inputStream.readInt();
        			System.out.print("registro: " + intValue1);
        			for(int j=0;j<4;j++) {
                		int temp = inputStream.readInt();
                	}
        			double voto = inputStream.readDouble();
        			media+=voto;
        			sc.nextInt();
        			System.out.println(sc.nextLine());
                }
        		System.out.println(media/s.length);
			} catch (IOException e1) {
				// TODO: handle exception
			}
            
        } catch (IOException e) {
        	
        }
    }
}
