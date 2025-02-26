package it.corso.esercitazionecatalogo.service;

import it.corso.esercitazionecatalogo.model.Articolo;
import it.corso.esercitazionecatalogo.repository.ArticoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticoloServiceImpl implements ArticoloService {

    @Autowired
    private ArticoloRepository articoloRepository;

    @Override
    public List<Articolo> elencoArticolo() {
        return (List<Articolo>) articoloRepository.findAll();
    }

    @Override
    public Articolo datiArticolo(int id) {
        Optional<Articolo> articolo = articoloRepository.findById(id);
        if (articolo.isPresent()) {
            return articolo.get();
        }
        return null;
    }
}
