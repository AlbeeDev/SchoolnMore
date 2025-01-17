package it.corso.repository;

import it.corso.model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepositoryAdvanced implements PersonaRepository {

    @Override
    public void createPersona(Persona persona) {
        String sql="insert into persone (nome, cognome, eta) values (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, persona.getNome());
            stmt.setString(2, persona.getCognome());
            stmt.setInt(3, persona.getEta());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Persona getPersona(int id) {
        String sql = "select * from persone where id = ?";
        try (Connection conn=getConnection(); PreparedStatement stmt=conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            Persona persona = new Persona();
            persona.setId(rs.getInt("id"));
            persona.setNome(rs.getString("nome"));
            persona.setCognome(rs.getString("cognome"));
            persona.setEta(rs.getInt("eta"));

            return persona;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Persona> elencoPersone() {
        String sql = "select * from persone";
        try (Connection conn=getConnection(); Statement stmt=conn.createStatement(); ResultSet rs=stmt.executeQuery(sql)) {
            List<Persona> persone = new ArrayList<Persona>();

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNome(rs.getString("nome"));
                persona.setCognome(rs.getString("cognome"));
                persona.setEta(rs.getInt("eta"));

                persone.add(persona);
            }

            return persone;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void aggiornamentoPersona(Persona persona) {
        String sql = "update persone set nome=?, cognome=?, eta=? where id = ?";
        try (Connection conn=getConnection(); PreparedStatement stmt=conn.prepareStatement(sql)) {
            stmt.setString(1, persona.getNome());
            stmt.setString(2, persona.getCognome());
            stmt.setInt(3, persona.getEta());
            stmt.setInt(4, persona.getId());
            stmt.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cancellaPersona(int id) {
        String sql="delete from persone where id = ?";
        try (Connection conn=getConnection(); PreparedStatement stmt=conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
