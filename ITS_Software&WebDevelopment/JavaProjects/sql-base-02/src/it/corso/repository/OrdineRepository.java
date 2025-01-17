package it.corso.repository;

import it.corso.model.Ordine;

import java.util.List;

public interface OrdineRepository extends Repository{
    List<Ordine> elencoOrdini();
}
