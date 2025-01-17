package it.corso.repository;

import it.corso.model.Fattura;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FatturaRepository {
    String URL = "jdbc:mysql://localhost:3306/gestionefatture";
    String USERNAME = "root";
    String PASSWORD = "studente2024";

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void creaFattura(Fattura fattura) {
        String sql="insert into fattura (data_emissione, imponibile, nome_cognome) values (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1,fattura.getDataEmissione());
            stmt.setDouble(2,fattura.getImponibile());
            stmt.setString(3,fattura.getNomeCognome());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Fattura> elencoFatture() {
        String sql = "select * from fattura";
        try (Connection conn=getConnection(); Statement stmt=conn.createStatement(); ResultSet rs=stmt.executeQuery(sql)) {
            List<Fattura> fatture = new ArrayList<Fattura>();

            while (rs.next()) {
                Fattura f = new Fattura();
                f.setNumero(rs.getInt("numero"));
                f.setDataEmissione(rs.getObject("data_emissione", LocalDate.class));
                f.setImponibile(rs.getInt("imponibile"));
                f.setNomeCognome(rs.getString("nome_cognome"));
                fatture.add(f);
            }

            return fatture;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
