import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainMenu extends JPanel{
    JFrame frame;
    JLabel title;
    JLabel unlabel;
    JTextField usernametf;
    JButton play;
    String serverIp;
    public MainMenu(JFrame frame){
        serverIp = "localhost";
        frame.add(this);
        setLayout(null);
        title= new JLabel("car game :V");
        title.setBounds(200,100,600,100);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("",Font.BOLD,60));
        add(title);

        unlabel = new JLabel("Username");
        unlabel.setBounds(200,200,600,100);
        unlabel.setHorizontalAlignment(JLabel.CENTER);
        unlabel.setFont(new Font("",Font.BOLD,30));
        add(unlabel);  // x, y, width, height

        // Create a JTextField for user input
        usernametf = new JTextField(15);
        usernametf.setBounds(350,300,300,50);
        usernametf.setHorizontalAlignment(JLabel.CENTER);
        usernametf.setText("");
        usernametf.setFont(new Font("",Font.PLAIN,20));
        add(usernametf);

        play= new JButton();
        play.setBounds(350,400,300,100);
        play.setBackground(Color.green);
        play.setText("PLAY");
        play.setFont(new Font("",Font.BOLD,30));
        add(play);

        ActionListener playevent = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!usernametf.getText().equals("")){
                    try {
                        Socket socket = new Socket(serverIp, 50000);
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        out.println("USER_VALIDATE:"+usernametf.getText());
                        String serverMessage;
                        //todo probably remove while
                        while ((serverMessage = in.readLine()) != null) {
                            if(serverMessage.equals("USER_VALID")){
                                setVisible(false);
                                //GamePanel gp = new GamePanel(frame,usernametf.getText());
                                LobbyMenu lm = new LobbyMenu(frame, socket, out, in);
                                System.out.println("Connection established.");
                            }
                            if(serverMessage.equals("USER_INVALID")){
                                socket.close();
                            }
                            break;
                        }

                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }

                }

            }
        };
        play.addActionListener(playevent);
    }
}
