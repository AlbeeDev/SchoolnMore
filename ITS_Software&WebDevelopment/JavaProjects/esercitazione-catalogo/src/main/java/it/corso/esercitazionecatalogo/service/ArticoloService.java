package it.corso.esercitazionecatalogo.service;

import it.corso.esercitazionecatalogo.model.Articolo;

import java.util.List;

public interface ArticoloService {
    List<Articolo> elencoArticolo();
    Articolo datiArticolo(int id);
}
