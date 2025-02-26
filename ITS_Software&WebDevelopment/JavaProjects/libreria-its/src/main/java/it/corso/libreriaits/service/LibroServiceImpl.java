package it.corso.libreriaits.service;

import it.corso.libreriaits.model.*;
import it.corso.libreriaits.repository.CarrelloRepository;
import it.corso.libreriaits.repository.LibroRepository;
import it.corso.libreriaits.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private AutoreService autoreService;
    @Autowired
    private OrdineRepository ordineRepository;
    @Autowired
    private CarrelloRepository carrelloRepository;

    @Override
    public List<Libro> elencoLibri() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    public Libro datiLibro(int id) {
        Optional<Libro> libro = libroRepository.findById(id);
        if (libro.isPresent()) {
            return libro.get();
        }
        return null;
    }

    @Override
    public void registrazioneLibro(Libro libro, String titolo, String prezzo, String copieDisponibili, Integer idCategoria, Integer idAutore, MultipartFile copertina) {
        //register book
        libro.setTitolo(titolo);
        libro.setPrezzo(Double.parseDouble(prezzo));
        libro.setCopieDisponibili(Integer.parseInt(copieDisponibili));
        libro.setCategoria(categoriaService.datiCategoria(idCategoria));
        libro.setAutore(autoreService.datiAutore(idAutore));

        if(copertina != null && !copertina.isEmpty()){
            try {
                String formato = copertina.getContentType();
                String copertina64 = "data:"+formato+";base64,"+ Base64.getEncoder().encodeToString(copertina.getBytes());
                libro.setCopertina(copertina64);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        libroRepository.save(libro);

    }

    @Override
    public String eliminazioneLibro(int id) {
        List<Ordine> ordini = (List<Ordine>) ordineRepository.findAll();
        for (Ordine ordine : ordini) {
            for (LibroOrdine libroOrdine : ordine.getLibriOrdine()){
                if(libroOrdine.getLibro().getId() == id){
                    return "Impossibile rimuovere (libro presente in ordini)";
                }
            }
        }
        List<Carrello> carrelli = (List<Carrello>) carrelloRepository.findAll();
        for (Carrello carrello : carrelli) {
            for (LibroCarrello libroCarrello : carrello.getLibriCarrello()){
                if(libroCarrello.getLibro().getId() == id){
                    return "Impossibile rimuovere (libro presente in carrelli)";
                }
            }
        }

        libroRepository.deleteById(id);
        return null;
    }
}
