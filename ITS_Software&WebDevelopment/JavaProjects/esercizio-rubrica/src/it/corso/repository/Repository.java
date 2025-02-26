package it.corso.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import it.corso.model.Address;
import it.corso.model.Contact;

public interface Repository {

	String URL = "jdbc:mysql://localhost:3306/esercizio_rubrica";
	String USERNAME = "root";
	String PASSWORD = "studente2024";

	default Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}