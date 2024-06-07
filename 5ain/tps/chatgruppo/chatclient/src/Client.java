import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Client {
    private JFrame frame;
    private JTextField ipField;
    private JTextField usernameField;
    private JButton connectButton;
    private ChatClientUI chatClientUI;

    public Client() {
        frame = new JFrame("Connect to Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2));

        ipField = new JTextField("localhost");
        usernameField = new JTextField();
        connectButton = new JButton("Connect");

        frame.add(new JLabel("Server IP:"));
        frame.add(ipField);
        frame.add(new JLabel("Username:"));
        frame.add(usernameField);
        frame.add(connectButton);

        frame.setVisible(true);

        connectButton.addActionListener(e -> {
            String serverIp = ipField.getText().trim();
            String username = usernameField.getText().trim();
            connectToServer(serverIp, username);
        });
    }

    private void connectToServer(String serverIp, String username) {
        try {
            Socket socket = new Socket(serverIp, 50000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(username);  // Send the username to the server

            // If connected successfully, close this window and open the chat window
            frame.dispose();
            chatClientUI = new ChatClientUI(socket, out, in);
            System.out.println("Connection established.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to connect to server.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}

class ChatClientUI {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField inputField;
    private JButton exitButton;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ChatClientUI(Socket socket, PrintWriter out, BufferedReader in) {
        this.socket = socket;
        this.out = out;
        this.in = in;

        frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        inputField = new JTextField();
        exitButton = new JButton("Exit");
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputField, BorderLayout.SOUTH);
        frame.add(exitButton, BorderLayout.NORTH);

        frame.setVisible(true);

        exitButton.addActionListener(e -> closeConnection());

        inputField.addActionListener(e -> sendMessage());

        // For reading messages from the server
        new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = in.readLine()) != null) {
                    textArea.append(serverMessage + "\n");
                    textArea.setCaretPosition(textArea.getDocument().getLength());
                }
            } catch (IOException ex) {
            }
        }).start();
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            out.println(message);
            inputField.setText("");
        }
    }

    private void closeConnection() {
        try {
            socket.close();
            System.out.println("Connection closed.");
            System.exit(0);
        } catch (IOException e) {
        }
    }
}




