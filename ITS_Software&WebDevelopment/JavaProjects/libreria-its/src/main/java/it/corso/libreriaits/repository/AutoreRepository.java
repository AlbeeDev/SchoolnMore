package it.corso.libreriaits.repository;

import it.corso.libreriaits.model.Autore;
import org.springframework.data.repository.CrudRepository;

public interface AutoreRepository extends CrudRepository<Autore, Integer> {
}
