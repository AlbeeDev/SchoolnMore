package it.corso.repository;

import it.corso.model.Libro;

public interface LibroRepository extends Repository{
    void registrazioneLibro(Libro libro, String cognomeAutore, String descrizioneCategoria);
}
