package it.corso.repository;

import it.corso.model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepositoryBase implements PersonaRepository {

    @Override
    public void createPersona(Persona persona) {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "insert into Persone(nome,cognome,eta) values ('"+persona.getNome()+"','"+persona.getCognome()+"','"+persona.getEta()+"')";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Persona getPersona(int id) {
        String sql = "select * from persone where id = '"+id+"'";
        try (Connection conn=getConnection(); Statement stmt=conn.createStatement(); ResultSet rs=stmt.executeQuery(sql)) {
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
        try (Connection conn=getConnection(); Statement stmt=conn.createStatement()) {
            String sql = "update persone set nome='"+persona.getNome()+"', cognome='"+persona.getCognome()+"', eta='"+persona.getEta()+"' where id = '"+persona.getId()+"'";
            stmt.executeUpdate(sql);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cancellaPersona(int id) {
        try (Connection conn=getConnection(); Statement stmt=conn.createStatement()) {
            String sql = "delete from persone where id = '"+id+"'";
            stmt.executeUpdate(sql);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
