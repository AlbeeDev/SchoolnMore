import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataPanel extends JPanel{
    private JTable table;
    private DefaultTableModel tableModel;

    public DataPanel() {
        tableModel = new DefaultTableModel(new Object[]{"username", "email", "password"}, 0);
        table = new JTable(tableModel);
        loadTableData();
        this.add(new JScrollPane(table));
    }

    private void loadTableData() {
        dbconnector dbConnector = new dbconnector();
        try {
            ResultSet rs = dbConnector.sendQuery("SELECT * FROM users");
            while (rs != null && rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password"); // Note: Storing passwords as plain text is not secure
                tableModel.addRow(new Object[]{username, email, password});
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnector.close();
        }
    }
}
