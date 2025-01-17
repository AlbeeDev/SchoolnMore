package it.corso.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Repository {
    String URL = "jdbc:mysql://localhost:3306/its_libreria";
    String USERNAME = "root";
    String PASSWORD = "studente2024";

    default Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
