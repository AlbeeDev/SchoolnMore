import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Main {
    public static void main(String[] args) throws Exception {
        
        JFrame fr = new JFrame();
        fr.setSize(800, 600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null); // Center the JFrame on the screen
        fr.setLayout(null);
        

        JButton send = new JButton();
        JButton view = new JButton();
        JTextField username = new JTextField();
        JTextField email = new JTextField();
        JTextField password = new JTextField();

        
        username.setBounds(300,100,200,50);
        email.setBounds(300,200,200,50);
        password.setBounds(300,300,200,50);

        send.setBounds(300,400,200,50);
        send.setText("add user");
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dbconnector db = new dbconnector();

                try {
                    String query="INSERT INTO users (username, email, password) VALUES ('" + username.getText() + "', '" + email.getText() + "', '" + password.getText() + "')";
                    System.out.println(query);
                    db.sendQuery(query);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                db.close();
            }
            
        };
        send.addActionListener(al);

        view.setBounds(300,500,200,50);
        view.setText("view table");
        ActionListener al2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.getContentPane().removeAll();
                DataPanel dp = new DataPanel();
                dp.setBounds(0,0,500,500);
                dp.setBackground(Color.pink);
                fr.add(dp);
                fr.revalidate();
                fr.repaint();
            }
            
        };
        view.addActionListener(al2);

        fr.add(view);
        fr.add(send);
        fr.add(username);
        fr.add(email);
        fr.add(password);
        fr.setVisible(true);
    }
}
