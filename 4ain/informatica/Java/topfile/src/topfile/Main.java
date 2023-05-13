package topfile;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;



class Frame {

   

   public Frame() {

       JFrame frame = new JFrame("Random");

       frame.setSize(400, 200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JButton button = new JButton("Nuovo Numero");

       JLabel label = new JLabel();

       button.addActionListener(e -> {
           int n=new Random().nextInt(100);
           label.setText(" "+n);
           try {
            filefunc2(n);
        } catch (IOException e1) {}
       });

       frame.add(button, BorderLayout.NORTH);
       frame.add(label, BorderLayout.SOUTH);
     
       frame.setVisible(true);

   }
   
   public void filefunc(int n) throws IOException {
       
       try (BufferedReader br= new BufferedReader(new FileReader("file.txt"))){
           String k=br.readLine();
           String[] sa= k.split(" ");
           Integer [] na= new Integer[sa.length+1];
           for(int i=0;i<sa.length;i++) {
               na[i]= Integer.parseInt(sa[i]);
           }
           na[sa.length]=n;
           Arrays.sort(na,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
                /*
                if(o1.intValue()==o2.intValue()) return 0;
                else if(o1.intValue()> o2.intValue()) return -1;
                else return 1;
                */
            }

           });
           na = Arrays.copyOf(na, 10);
           
           System.out.println(Arrays.toString(na));
           System.out.println(k);
           try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt"))){
               for(Integer x:na) {
                   pw.print(x+" ");
               }
           }
       }catch(Exception e) {}
       
       System.out.println(" "+n);
   }
   public void filefunc2(int n) throws IOException
   {
       try(Scanner sr = new Scanner(new FileReader("file.txt"))){
           List<Integer> list = new ArrayList<>();
//           var list = new ArrayList<>();
           list.add(n);
           while(sr.hasNextInt()) {
               list.add(sr.nextInt());
           }
           Collections.sort(list, Collections.reverseOrder());
           list.sort(Collections.reverseOrder());
/*
           list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
*/    
           System.out.println(list);
               while(list.size()>10 && !list.get(list.size()-1).equals(list.get(list.size()-2))) {
                   list.remove(list.size()-1);
               }
               System.out.println(list);
           try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt"))){
               for(Integer x:list) {
                   pw.print(x+" ");
               }
           }
       }
   }
}

public class Main {



   public static void main(String[] args) {

       new Frame();

   }
   
}