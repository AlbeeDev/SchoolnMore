package it.corso.libreriaits.service;

import it.corso.libreriaits.model.Autore;
import it.corso.libreriaits.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoreServiceImpl implements AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    @Override
    public List<Autore> elencoAutori() {
        return (List<Autore>) autoreRepository.findAll();
    }

    @Override
    public Autore datiAutore(int id) {
        return autoreRepository.findById(id).get();
    }
}
