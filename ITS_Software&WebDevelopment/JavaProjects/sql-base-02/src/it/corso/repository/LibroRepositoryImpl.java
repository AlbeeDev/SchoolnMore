package it.corso.repository;

import it.corso.model.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LibroRepositoryImpl implements LibroRepository {
    @Override
    public void registrazioneLibro(Libro libro, String cognomeAutore, String descrizioneCategoria) {
        String sql="insert into libri(titolo, prezzo, id_autore, id_categoria) values(?,?,(select id from autori where cognome=?),(select id from categorie where descrizione=?))";

        try (Connection connection = getConnection(); PreparedStatement stmt= getConnection().prepareStatement(sql)){
            stmt.setString(1, libro.getTitolo());
            stmt.setDouble(2, libro.getPrezzo());
            stmt.setString(3,cognomeAutore);
            stmt.setString(4,descrizioneCategoria);
            stmt.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
