package it.corso.libreriaits.service;

import it.corso.libreriaits.model.Categoria;
import it.corso.libreriaits.model.Libro;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LibroService {
    List<Libro> elencoLibri();
    Libro datiLibro(int id);
    void registrazioneLibro(Libro libro, String titolo, String prezzo, String copieDisponibili, Integer idCategoria, Integer idAutore, MultipartFile copertina);
    String eliminazioneLibro(int id);
}
