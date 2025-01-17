package it.corso.repository;

import it.corso.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdineRepositoryImpl implements OrdineRepository {

    @Override
    public List<Ordine> elencoOrdini() {
        String sql = "select o.id,o.data,o.importo,u.id,u.nome,u.cognome,p.id,p.username,p.password from ordini o join its_libreria.utenti u on u.id = o.id_utente join its_libreria.profili p on p.id = u.id_profilo";

        try (Connection conn=getConnection(); Statement stmt=conn.createStatement(); ResultSet rs=stmt.executeQuery(sql)) {
            List<Ordine> ordini = new ArrayList<Ordine>();

            while (rs.next()) {
                Ordine ordine = new Ordine();
                Utente utente = new Utente();
                Profilo profilo = new Profilo();
                profilo.setId(rs.getInt("p.id"));
                profilo.setUsername(rs.getString("p.username"));
                profilo.setPassword(rs.getString("p.password"));
                utente.setId(rs.getInt("u.id"));
                utente.setNome(rs.getString("u.nome"));
                utente.setCognome(rs.getString("u.cognome"));
                utente.setProfilo(profilo);
                ordine.setId(rs.getInt("o.id"));
                ordine.setData(rs.getObject("o.data", LocalDate.class));
                ordine.setImporto(rs.getDouble("o.importo"));
                ordine.setUtente(utente);

                setLibriOrdine(conn, ordine);

                ordini.add(ordine);
            }

            return ordini;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void setLibriOrdine(Connection connection, Ordine ordine){
        String sql="select l.id,l.titolo,l.prezzo,c.id,c.descrizione,a.id,a.nome,a.cognome from ordini_libri ol join its_libreria.libri l on l.id = ol.id_libro join its_libreria.categorie c on c.id = l.id_categoria join its_libreria.autori a on a.id = l.id_autore where ol.id_ordine=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, ordine.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                Autore autore = new Autore();
                Libro libro = new Libro();
                categoria.setId(rs.getInt("c.id"));
                categoria.setDescrizione(rs.getString("c.descrizione"));
                autore.setId(rs.getInt("a.id"));
                autore.setNome(rs.getString("a.nome"));
                autore.setCognome(rs.getString("a.cognome"));
                libro.setId(rs.getInt("l.id"));
                libro.setTitolo(rs.getString("l.titolo"));
                libro.setPrezzo(rs.getDouble("l.prezzo"));
                libro.setCategoria(categoria);
                libro.setAutore(autore);

                ordine.getLibri().add(libro);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
