package it.corso.libreriaits.repository;

import it.corso.libreriaits.model.Ordine;
import org.springframework.data.repository.CrudRepository;

public interface OrdineRepository extends CrudRepository<Ordine, Integer> {
}
