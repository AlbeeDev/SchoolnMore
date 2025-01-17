package it.corso.repository;

import it.corso.model.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public interface PersonaRepository {
    String URL = "jdbc:mysql://localhost:3306/its_base_01";
    String USERNAME = "root";
    String PASSWORD = "studente2024";

    void createPersona(Persona persona);
    Persona getPersona(int id);
    List<Persona> elencoPersone();
    void aggiornamentoPersona(Persona persona);
    public void cancellaPersona(int id);

    default Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
