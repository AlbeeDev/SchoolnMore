package it.corso.libreriaits.service;

import it.corso.libreriaits.model.Autore;

import java.util.List;

public interface AutoreService {
    List<Autore> elencoAutori();
    Autore datiAutore(int id);
}
