package steganografia;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;

class Panel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Image img1 = ImageIO.read(new File("Immagine.bmp"));
            g.drawImage(img1, 30, 100, null);
            Image img2 = ImageIO.read(new File("Immagine1.bmp"));
            g.drawImage(img2, 130, 100, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Gui extends JFrame{
    JTextField testo;
    JButton button;
    JButton decodifica;
    JPanel panel;

    private static byte[] toByteArray(byte b) {
        byte[] ba = new byte[8];
        for(int i=0; i<8; ++i) {
            ba[i] = 0;
            if((b&1)!=0)
                ba[i] |= 1;
            b>>=1;
        }
        return ba;
    }

    private static byte toByte(byte[] ba) {
        short c = 0;
        for(byte b : ba) {
            if((b&1)!=0)
                c |= 128;
            c>>=1;
        }
        return (byte)c;
    }
   
    public Gui() {
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new Panel();
        panel.setBackground(Color.cyan);
        panel.setBounds(0, 0, 700, 600);

        testo = new JTextField();
        testo.setBounds(50, 400, 400, 50);

        decodifica = new JButton("Decodifica");
        decodifica.setBounds(500, 450, 100, 50);
        decodifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(DataInputStream img = new DataInputStream(new FileInputStream("Immagine.bmp"))){
                    byte[] bytdec = new byte[100];
                    int lung = 0;
                    img.skipBytes(11);
                    int offset = img.readInt();
                    img.skipBytes(offset);
                    System.out.println(offset);

                    for(int k=0; k<10; ++k){
                        byte[] ba = new byte[8];
                        img.read(ba);
                        bytdec[lung++] = toByte(ba);
                    }
                    System.out.println(new String(bytdec,0,lung));
                } catch (FileNotFoundException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                } catch (IOException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }
            }
        });

        button=new JButton("Converti");
        button.setBounds(500, 380, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = testo.getText();
                try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("Immagine.bmp")))){
                    try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("Immagine1.bmp"))){


                        byte[] barr = new byte[str.getBytes().length+1];
                        System.arraycopy(str.length(), 0, barr, 0, 4);
                        System.arraycopy(str.getBytes(), 0, barr, 4, str.getBytes().length);
                        for(byte b : barr){
                            for(int i=0; i<8; ++i) {
                                byte bImg = dis.readByte();
                                if((b&1)==0)
                                    bImg &= ~1;
                                else
                                    bImg |= 1;
                                dos.writeByte(bImg);
                                b>>=1;
                            }
                        }
                        //mig.write(img.readAllBytes());
        //                int n=0;
                        while(dis.available()!=0) {
//                            if(++n%1024==0)
    //                            System.out.println(n/1024+"kB");
                            dos.writeByte(dis.readByte());
                        }
                        System.out.println("FINITO");
                    }
                } catch (FileNotFoundException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                } catch (IOException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }
            }
        });

        add(decodifica);
        add(button);
        add(testo);
        add(panel);
        setVisible(true);
}
}

public class MyMain {
    public static void main(String[] args) {
        new Gui();
    }
}