package it.corso.esercitazionecatalogo.repository;

import it.corso.esercitazionecatalogo.model.Articolo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloRepository extends CrudRepository<Articolo, Integer> {
}
