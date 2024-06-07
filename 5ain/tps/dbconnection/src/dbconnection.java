import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import java.sql.ResultSetMetaData;

public class dbconnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/5aclassiscuola";
        String username = "root";
        String password = "";

        JFrame fr = new JFrame();
        fr.setSize(800, 600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null); // Center the JFrame on the screen
        
        
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // Create a statement for executing SQL queries
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            // Execute a sample SQL query and obtain a ResultSet
            String query1 = "SELECT * FROM Tstudenti";
            ResultSet rs = statement.executeQuery(query1);
            ResultSetMetaData rsmd = rs.getMetaData();

            /* 
            // Iterate through the ResultSet and process the data
            while (resultSet.next()) {
                // Access data using column names or indices
                String classe = resultSet.getString("Tclassi.nome");
                String cognomestud = resultSet.getString("Tstudenti.cognome");
                String nomestud = resultSet.getString("Tstudenti.nome");
                String nazione = resultSet.getString("Tnazionalita.nome");
                
                
                // Process the retrieved data here
                System.out.println("classe: "+ classe +" cognome: "+cognomestud+" nome: "+nomestud+" nazione: "+nazione);
                
            }
            */
            int numcol = rsmd.getColumnCount();
            rs.last();
            int numrow = rs.getRow();
            rs.beforeFirst();
            
            String[] nomecol = new String[numcol]; 
            Object[][] data = new Object[numrow][numcol];
            int idx = 0;
            while (rs.next()) {
                for (int i = 0; i < numcol; i++) {
                    Object columnValue = rs.getObject(i+1);
                    String columnName = rsmd.getColumnName(i+1);
                    nomecol[i]=columnName;
                    System.out.println(columnName + ": " + columnValue);
                    data[idx][i]=rs.getObject(columnName);
                }
                idx++;
                System.out.println();
            }
            
            System.out.println(numrow);

            JTable table = new JTable(data, nomecol);
            fr.add(table);

            fr.setVisible(true);
            
            // Close the ResultSet, Statement, and Connection
            rs.close();
            statement.close();
            connection.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
