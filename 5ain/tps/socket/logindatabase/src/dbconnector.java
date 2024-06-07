import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class dbconnector{
    private String url = "jdbc:mysql://localhost:3306/userdatabase";
    private String username = "root";
    private String password = "";

    private Connection connection;

    dbconnector(){
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    public ResultSet sendQuery(String sql) throws SQLException {
        Statement stmt = connection.createStatement();

        if (sql.trim().toUpperCase().startsWith("SELECT")) {
            return stmt.executeQuery(sql);
        } else {
            stmt.executeUpdate(sql);
            return null; // No ResultSet for update operations
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close the database connection", e);
        }
    }


}